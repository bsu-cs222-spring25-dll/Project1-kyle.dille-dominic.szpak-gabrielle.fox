package bsuCS;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testApiUrl {
        @Test
        public void passingURLTest() throws IOException {
            String rawURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&"
            +"titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=4&redirects";
            URL formattedURL = new URL(rawURL);
            URL trialAPIURL = urlFinder.getapi("Frank Zappa");
            assertEquals(formattedURL,trialAPIURL);
        }
        @Test
        public void wikiApiTest() throws IOException {
            wikiArticle exampleArticle = new wikiArticle();
            InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
            String timestamp = wikiArticle.pullTimestamps(testDataStream).getFirst().toString();
            assertEquals("2025-01-29T16:45:38Z",timestamp);
        }
        @Test
        public void wikipediaJSONTest() throws Exception {
            //JSONObject jsonFetcher = new JsonFetcher();
            JSONObject wikiTestFile = JsonFetcher.fetchJsonFromUrl(urlFinder.getapi("Frank Zappa"));

            assertEquals(wikiTestFile,"");
    }
    }

