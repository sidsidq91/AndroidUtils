package personal.com.sample.Utils.NetWorking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public static List<Object> parseJsonFeed(String content){
        try {
            JSONArray array = new JSONArray(content);

            List<Object> data = new ArrayList<>();
            for (int i=0; i<array.length(); i++){
                JSONObject jsonObject = array.getJSONObject(i);
                Object object = new Object();
                //call setter method to feed object variables
                jsonObject.getString("tagName");
                jsonObject.getInt("tagName");
                data.add(object);
            }
            return data;
        } catch (JSONException e) {
            e.printStackTrace();
            //return null in case of exception
            return null;
        }
    }
}
