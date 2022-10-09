package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class RequestCreator {
    String requestBody;

    public String importFile(String filepath) {
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources"+filepath));
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    void createPayload()
    {
        try{
            JSONObject payload = new JSONObject(importFile("\\payloads\\payload.json"));
            System.out.println(payload.toString());
            JSONObject data = selectDataObject("\\data\\payloadData.json", "half request");
            mapData(payload,data);
        } catch (JSONException e) {
            JSONArray payload = new JSONArray(importFile("\\payloads\\payload.json"));
            System.out.println(payload.toString());
            JSONObject data = selectDataObject("\\data\\payloadData.json","half request");
            mapData(payload,data);


        }
    }

    public void mapData(Object payload, JSONObject data)
    {
        String payloadTxt = payload.toString();
        for (String key: data.keySet())
        {
            System.out.println(key);
            if (payloadTxt.contains("("+key+")"))
            {
                String replacement = data.get(key).toString();
                payloadTxt = payloadTxt.replace("("+key+")",replacement);
            }
        }
        payloadTxt = payloadTxt.replaceAll("\"\\(.*?\\)\"","null");
        System.out.println(payloadTxt);
        requestBody = removeEmptyJsonElements(new JSONTokener(payloadTxt).nextValue());
        System.out.println(requestBody);

    }

    public JSONObject selectDataObject(String filepath, String dataType)
    {
        JSONObject json = new JSONObject(importFile(filepath));
        JSONArray dataset = json.getJSONArray("dataset");
        JSONObject datatype = new JSONObject();
        for(int i=0; i<dataset.length(); i++)
        {
            datatype = dataset.getJSONObject(i);
            if(datatype.get("tag").equals(dataType))
            {
                break;
            }
        }
        System.out.println(datatype.toString());
        return datatype;
    }

    public String removeEmptyJsonElements(Object object){

        if (object instanceof JSONArray)
        {
            JSONArray array = (JSONArray)object;
            Iterator<Object> elements = array.iterator();
            while(elements.hasNext())
                removeEmptyJsonElements(elements.next());
//            for(int i = 0; i<array.length(); i++)
//                removeEmptyJsonElements(array.get(i));
        }
        else if (object instanceof JSONObject)
        {
            final JSONObject jsonObject = (JSONObject)object;
            JSONArray names = jsonObject.names();
            Iterator<Object> els = names.iterator();
            while(els.hasNext())
//            for(int j = 0; j<names.length(); j++)
            {
                String key = els.next().toString();
//                String key = names.getString(j);
                if (jsonObject.isNull(key)||jsonObject.isEmpty())
                    jsonObject.remove(key);
                else
                    removeEmptyJsonElements(jsonObject.get(key));
            }


            JSONArray nmes =jsonObject.names();
            if (nmes!=null) {
                Iterator<Object> keys = nmes.iterator();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    if (jsonObject.get(key) instanceof JSONObject) {
                        if (jsonObject.get(key).toString().equals("{}")) {
                            jsonObject.remove(key);
                        }
                    }
                }
            }
        }

        return object.toString();
    }
}
