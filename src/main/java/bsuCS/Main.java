package bsuCS;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Input article name
        System.out.println("Enter the name of a Wikipedia article:");
        String articleName = scnr.nextLine();

        try {
            // fetches the URL for the Wikipedia API using urlFinder class
            URL apiUrl = urlFinder.getapi(articleName);

            // fetches data from article
            String wikiJson = JsonFetcher.fetchJsonFromUrl(apiUrl);
            InputStream testDataStream = new ByteArrayInputStream(wikiJson.getBytes(StandardCharsets.UTF_8));
            wikiArticle article = new wikiArticle(testDataStream);


            //call to format
            String message = PrintFormat.format(article);
            System.out.println(message);


        } catch (IOException e) {
            System.err.println("Error retrieving the Wikipedia article: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing the Wikipedia data: " + e.getMessage());
        }
    }
}

