package bsuCS;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class wikiPullModel {
    public static String pullEditHistory(String articleName) throws Exception{
        // fetches the URL for the Wikipedia API using urlFinder class
        URL apiUrl = urlFinder.getapi(articleName);

        // fetches data from article
        String wikiJson = JsonFetcher.fetchJsonFromUrl(apiUrl);
        InputStream jsonStream = new ByteArrayInputStream(wikiJson.getBytes(StandardCharsets.UTF_8));
        wikiArticle article = new wikiArticle(jsonStream);


        //call to format
        String message = PrintFormat.format(article);
        return message;
    }
}
