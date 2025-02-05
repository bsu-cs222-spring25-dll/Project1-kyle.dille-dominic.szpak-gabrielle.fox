package bsuCS;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;

public class wikiArticle {
    public static String recentTimestamp(InputStream testDataStream) throws IOException {
        String result = JsonPath.read(testDataStream, "$..timestamp").toString();

        return result;
    }
}
