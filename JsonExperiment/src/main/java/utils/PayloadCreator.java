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

public class PayloadCreator {

    String payload;
    Object request;


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
    public void displayPayload()
    {
        try{
            JSONObject json = new JSONObject(importFile("\\payloads\\payload.json"));
            System.out.println(json);
            JSONObject data = selectDataObject("\\data\\payloadData.json","half request");
            System.out.println(data);
            String payloadTxt = json.toString();
            for (String key: data.keySet())
            {
                System.out.println(key);
                if (payloadTxt.contains("("+key+")"))
                {
                    String replacement = data.get(key).toString();
                    payloadTxt = payloadTxt.replace("("+key+")",replacement);
                }
            }
            System.out.println(payloadTxt);
            payloadTxt = payloadTxt.replaceAll("\"\\(.*\\)\"","null");
            System.out.println(payloadTxt);
            payload = removeEmptyJsonElements(new JSONTokener(payloadTxt).nextValue());
        }catch (JSONException e){
            JSONArray json = new JSONArray(importFile("\\payloads\\payload.json"));
            System.out.println(json);
            JSONObject data = selectDataObject("\\data\\payloadData.json","half request");
            System.out.println(data);
            String payloadTxt = json.toString();
            for (String key: data.keySet())
            {
                System.out.println(key);
                if (payloadTxt.contains("("+key+")"))
                {
                    String replacement = data.get(key).toString();
                    payloadTxt = payloadTxt.replace("("+key+")",replacement);
                }
            }
            System.out.println(payloadTxt);
            payloadTxt = payloadTxt.replaceAll("\"\\(.*\\)\"","null");
            System.out.println(payloadTxt);
            payload = removeEmptyJsonElements(new JSONTokener(payloadTxt).nextValue());
            System.out.println(payload);
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
        payloadTxt = payloadTxt.replaceAll("\"\\(.*\\)\"","null");
        payload = removeEmptyJsonElements(new JSONTokener(payloadTxt).nextValue());

    }

    public JSONObject
    selectDataObject(String filepath, String dataType)
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
        return datatype;
    }

    public String removeEmptyJsonElements(Object object){

        if (object instanceof JSONArray)
        {
            JSONArray array = (JSONArray)object;
            for(int i = 0; i<array.length(); i++)
                removeEmptyJsonElements(array.get(i));
        }
        else if (object instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject)object;
            JSONArray names = jsonObject.names();
            for(int j = 0; j<names.length(); j++)
            {
                String key = names.getString(j);
                if (jsonObject.isNull(key)||jsonObject.getString(key).equals("{}"))
                    jsonObject.remove(key);
                else
                    removeEmptyJsonElements(jsonObject.get(key));
            }
        }
        return object.toString();
    }

}
