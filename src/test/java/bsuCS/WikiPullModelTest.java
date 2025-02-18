package bsuCS;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class WikiPullModelTest {

    private wikiPullModel wikiPullModel;
    @Before
    public void setUp() {
        // WikiPullModel instance, mocked dependencies
        wikiPullModel = new wikiPullModel();
    }

    @Test
    public void testFetchEditHistoryFromWikipedia_Success() throws Exception {
        // defines input data
        String articleName = "Java_(programming_language)";
        String mockJson = "{\"some\": \"mock json\"}"; // Mock JSON response
        wikiArticle mockArticle = mock(wikiArticle.class);
        String formattedMessage = "Formatted edit history message";

        try {
            // return predefined data
            when(JsonFetcher.fetchJsonFromUrl(any())).thenReturn(mockJson);  // Return mock JSON
            when(PrintFormat.format(any(wikiArticle.class))).thenReturn(formattedMessage);  // Return formatted string

            //Calsl the method to teste
            String result = wikiPullModel.fetchEditHistoryFromWikipedia(articleName);

            // verifies output
            assertEquals(formattedMessage, result);
        } catch (IOException e) {
            fail("Exception should not be thrown in the success case");
        }
    }

    @Test
    public void testFetchEditHistoryFromWikipedia_Failure_IOException() throws Exception {
        // definine input data
        String articleName = "Java_(programming_language)";
        when(JsonFetcher.fetchJsonFromUrl(any())).thenThrow(new IOException("Mocked IOException"));

        try {

            wikiPullModel.fetchEditHistoryFromWikipedia(articleName);


            fail("IOException was expected but not thrown.");
        } catch (IOException e) {

            assertEquals("Error fetching or parsing the Wikipedia article.", e.getMessage());
        }
    }

    @Test
    public void testFetchEditHistoryFromWikipedia_Failure_JsonParsingException() throws Exception {

        String articleName = "Java_(programming_language)";
        String mockJson = "{\"some\": \"mock json\"}";
        when(JsonFetcher.fetchJsonFromUrl(any())).thenReturn(mockJson);

        try {

            wikiPullModel.fetchEditHistoryFromWikipedia(articleName);


            fail("IOException was expected but not thrown.");
        }catch(Exception e){
        assertEquals("Error fetching or parsing the Wikipedia article.", e.getMessage());
    }
}
}
