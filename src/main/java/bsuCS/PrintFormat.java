package bsuCS;

import net.minidev.json.JSONArray;

public class PrintFormat {

    public static String format(wikiArticle article){
        JSONArray timestamps = article.timestampsArray;
        JSONArray users = article.usersArray;
        String redirect = article.redirect;
        String formattedString= "directed to " +redirect+'\n';
        for(int i = 0; i< timestamps.size();i++){
            String timestamp = (String) timestamps.get(i);
            String user = (String) users.get(i);
            formattedString = formattedString + " " + (i+1) + "     "+ timestamp + "  " + user + '\n';
        }

        return formattedString;
    }
}
