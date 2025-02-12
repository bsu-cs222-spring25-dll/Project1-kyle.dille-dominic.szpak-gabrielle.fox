package bsuCS;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

public class wikiArticle {
    String redirect;
    JSONArray timestampsArray;
    JSONArray usersArray;

    wikiArticle(InputStream testDataStream) throws IOException {
        pullRedirects(testDataStream);
        pullTimestamps(testDataStream);
        pullRevisionUser(testDataStream);
    }

    public void pullTimestamps(InputStream testDataStream) throws IOException {
        timestampsArray = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        testDataStream.reset();
    }
    public void pullRevisionUser(InputStream testDataStream) throws IOException{
        usersArray = (JSONArray) JsonPath.read(testDataStream, "$..user");
        testDataStream.reset();
    }
    public void pullRedirects(InputStream testDataStream) throws IOException {
        redirect = JsonPath.read(testDataStream,"$..redirects[0].to").toString();
        testDataStream.reset();
    }

}
