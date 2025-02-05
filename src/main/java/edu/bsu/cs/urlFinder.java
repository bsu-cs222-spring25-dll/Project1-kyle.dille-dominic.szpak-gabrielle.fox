package edu.bsu.cs;

public class urlFinder {
    public String getapi(String s) {
        String apiCall = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
        + s + "&formatversion=2&rvprop=timestamp%7Cuser&rvslots=*&rvlimit=21";
        return s;
    }
}
