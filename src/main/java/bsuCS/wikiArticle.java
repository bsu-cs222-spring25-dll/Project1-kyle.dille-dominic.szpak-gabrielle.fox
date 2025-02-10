package bsuCS;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class wikiArticle {
    public static JSONArray pullTimestamps(InputStream testDataStream) throws IOException {
        JSONArray timestampsArray = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return timestampsArray;
    }
    public static JSONArray pullRevisionUser(InputStream testDataStream) throws IOException{
        JSONArray usersArray = (JSONArray) JsonPath.read(testDataStream, "$..user");
        return usersArray;
    }
    public static String pullRedirects(InputStream testDataStream) throws IOException {
        String redirectString = JsonPath.read(testDataStream,"$..to").toString();
        return redirectString;
    }
}
