package bsuCS;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class urlFinder {
    public static URL getapi(String title) throws IOException {
        //Shristi Khadka helped with formatting URL code
        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);

        String apiUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                + encodedTitle + "&rvprop=timestamp|user&rvlimit=4&redirects";

        URL url = new URL(apiUrl);
        return(url);
    }
}
