import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUpdate {
    public static String fetchFile(String filename) {
        StringBuffer jsonTxt = new StringBuffer();
        String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\WhitePhoenix\\resources\\"+filename+".json";
        try {
            File file = new File(filepath);
            InputStream inputStream = Files.newInputStream(file.toPath(), StandardOpenOption.READ);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader lineReader = new BufferedReader(reader);
            String line;
            while ((line = lineReader.readLine()) != null) {
                jsonTxt.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonTxt.toString();
    }

    @Test
    public void jsonUpdater()
    {
        String jsontext = fetchFile("payloads\\update");
//        StringBuffer jsontext = new StringBuffer(text);
        System.out.println(jsontext);
        JSONObject jsonObject = new JSONObject(fetchFile("data\\jsonData"));
        System.out.println(jsonObject.get("env_name"));
        for(String key:jsonObject.keySet())
        {
            System.out.println(key);
            if(jsontext.contains("{"+key+"}"))
            {
                String replacement = jsonObject.get(key).toString();
                jsontext = jsontext.replace("{"+key+"}", replacement);
            }
        }
        System.out.println(jsontext);
        jsontext = jsontext.replaceAll("\\{.*}","");
        System.out.println(jsontext);
        removeEmptyJsonElements(new JSONArray(jsontext));

    }

//    void removeEmptyJson(String json)
//    {
//        JSONObject object = new JSONObject(json);
//        JSONArray names = object.names();
//        for(int i=0;i< names.length();++i)
//        {
//            String key = names.getString(i);
//            if (object.getJSONArray(key).length()>0)
//                {
//                   removeEmptyJsonArrayElements(object.getJSONArray(key));
//                }
//            else{
//                removeEmptyJsonElements(object.getJSONObject(key));
//            }
//            }
//        System.out.println(object.toString());
//    }
//
//    private void removeEmptyJsonArrayElements(JSONArray jsonArray) {
//        for (int i = 0; i<jsonArray.length();i++)
//        {
//            removeEmptyJsonElements(jsonArray.getJSONObject(i));
//        }
//    }
//
//    private void removeEmptyJsonElements(JSONObject jsonObject) {
//
//        JSONArray names = jsonObject.names();
//        for (int i = 0; i < names.length(); ++i) {
//            String key = names.getString(i);
//            try {
//                if (jsonObject.isNull(key) || jsonObject.getJSONArray(key).length() == 0) {
//                    jsonObject.remove(key);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    void removeEmptyJsonElements(Object object)
    {
        if (object instanceof JSONArray) {
            JSONArray array = (JSONArray) object;
            for (int i = 0; i < array.length(); ++i)
                removeEmptyJsonElements(array.get(i));
        }
        else if (object instanceof JSONObject) {
            JSONObject json = (JSONObject) object;
            JSONArray names = json.names();
            for (int i = 0; i < names.length(); ++i) {
                String key = names.getString(i);
                try{
                    if (json.getJSONObject(key)==null||json.optJSONArray(key)==null||json.getJSONObject(key).isEmpty()) {
                        json.remove(key);
                    } else {
                        removeEmptyJsonElements(json.get(key));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(object.toString());
        }

    }
}
