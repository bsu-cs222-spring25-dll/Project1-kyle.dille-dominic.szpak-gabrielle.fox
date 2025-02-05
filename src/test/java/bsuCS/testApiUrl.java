package bsuCS;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testApiUrl {
        @Test
        public void passingURLTest() throws IOException {
            String rawURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Shaandaar"
                    + "&formatversion=2&rvprop=timestamp%7Cuser&rvslots=*&rvlimit=21";
            URL formattedURL = new URL(rawURL);
            URL trialAPIURL = urlFinder.getapi("Shaandaar");
            assertEquals(formattedURL,trialAPIURL);
        }
    }

