package bsuCS;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of a Wikipedia article:");
        String articleName = scanner.nextLine();

        try {
           wikiPullModel wikiPullModel = new wikiPullModel();
           String outputMessage = wikiPullModel.fetchEditHistoryFromWikipedia(articleName);
           System.out.println(outputMessage);

        } catch (IOException e) {
            System.err.println("Error retrieving the Wikipedia article: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing the Wikipedia data: " + e.getMessage());
        }
    }
}

