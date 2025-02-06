package bsuCS;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class wikiArticle {
    private JSONArray timestamps;
    public static JSONArray pullTimestamps(InputStream testDataStream) throws IOException {
        JSONArray timestamps = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return timestamps;
    }
    public static void pullRevisionUser(InputStream testDataStream) throws IOException{
        JSONArray users = (JSONArray) JsonPath.read(testDataStream, "$..user");
    }
}
