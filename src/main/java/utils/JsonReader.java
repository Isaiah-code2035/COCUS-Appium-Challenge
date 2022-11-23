package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/*
/ this is the JsonReader class which get the data to be used from the path passed and iiterate to get the exact data for to data provider
 */
public class JsonReader {
    public static Object[][] getJSONdata(String JSON_path, String JSON_data, int JSON_attributes) throws IOException, ParseException {
            Object obj = new JSONParser().parse(new FileReader((JSON_path)));
            JSONObject jo = (JSONObject) obj;
            JSONArray js = (JSONArray) jo.get(JSON_data);

            Object[][] arr;
        arr = new String[js.size()][JSON_attributes];
        for (int i = 0; i < js.size(); i++) {
                JSONObject obj1 = (JSONObject) js.get(i);
                JSONObject nameObj = (JSONObject) obj1.get("name");
                JSONObject descObj = (JSONObject) obj1.get("registered");
                arr[i][0] = nameObj.get("title") + " "+ nameObj.get("first")+" "+ nameObj.get("last");
                arr[i][1] = descObj.get("date");
            }
            return arr;
        }
}
