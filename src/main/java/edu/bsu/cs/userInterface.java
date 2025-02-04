package edu.bsu.cs;

import java.util.Scanner;



public class userInterface {
    Scanner promtUser = new Scanner(System.in);
    public String recentInput() {
        System.out.println("Input a wikipedia article title");
        String userInput = promtUser.nextLine();
        return userInput;
    }
}
