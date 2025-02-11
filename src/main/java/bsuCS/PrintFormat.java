package bsuCS;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class PrintFormat {
    public void print(){

    }
    public static String format(JSONArray timestamps, JSONArray users){
        String formattedString ="";
        for(int i = 0; i< timestamps.size();i++){
            String timestamp = (String) timestamps.get(i);
            String user = (String) users.get(i);
            formattedString = formattedString + " " + (i+1) + "     "+ timestamp + "  " + user + '\n';
        }

        return formattedString;
    }
}
