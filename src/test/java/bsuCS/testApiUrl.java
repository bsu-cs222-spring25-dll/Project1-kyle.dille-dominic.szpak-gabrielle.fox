package bsuCS;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testApiUrl {
        @Test
        public void passingURLTest() throws IOException {
            String rawURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&"
            +"titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=21&redirects";
            URL formattedURL = new URL(rawURL);
            URL trialAPIURL = urlFinder.getApi("Frank Zappa");
            assertEquals(formattedURL,trialAPIURL);
        }

        @Test
        public void wikiApiTest() throws IOException {

            InputStream jsonStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
            wikiArticle exampleArticle = new wikiArticle(jsonStream);
            String timestamp = exampleArticle.timestampsArray.getFirst().toString();

            assertEquals("2025-01-29T16:45:38Z",timestamp);
        }
        //Test broke and I don't know why

        @Test
        public void wikipediaJSONTest() throws Exception {
            String wikiTestFile = JsonFetcher.fetchJsonFromUrl(urlFinder.getApi("Zappa"));
            InputStream jsonStream = new ByteArrayInputStream(wikiTestFile.getBytes(StandardCharsets.UTF_8));
            wikiArticle article = new wikiArticle(jsonStream);
            JSONArray testTimestampsArray = (JSONArray) JsonPath.read(jsonStream, "$..timestamp");
            assertEquals(article.timestampsArray,testTimestampsArray);
    }

    }

