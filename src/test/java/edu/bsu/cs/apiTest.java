package edu.bsu.cs;

import org.junit.jupiter.api.*;

public class apiTest {
    @Test
    public void testApiURL(){
        String testURL = "https://en.wikipedia.org/w/api.php" +
                "?action=query&format=json&prop=revisions" +
                "&titles=Shaandaar&formatversion=2&rvprop=timestamp%7Cuser&rvslots=*&rvlimit=21";
        urlFinder urlFinder = new urlFinder();
        String apiUrl = urlFinder.getapi("");
        Assert.assertEquals(testURL,apiUrl);

    }

}
