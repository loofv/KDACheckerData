package org.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;                                  //fixa imports, importerar allt for now.
import java.util.stream.Collectors;
import java.net.*;
import org.json.*;

public class Match {

  KeyReader kr = new KeyReader();
  private final String        API_KEY   = kr.readKey();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/";
  private String              query;     //= ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader
  private String              sep       = System.getProperty("file.separator");
  private String              jsonPath  = System.getProperty("user.home")
                                                              + sep + "json" + sep + "testMatchIdentities.json";


  public void GetStats() {

    String queryAccountId;
    String queryMatchList;
    String queryMatchStats;
    String urlString;
    String summonerName;
    try {
        summonerName = "lOOFv";
        queryAccountId = "summoner/v3/summoners/by-name/"+ summonerName +"?api_key=";
        urlString = END_POINT + queryAccountId + API_KEY;
        URL url = new URL (urlString);
        StringBuilder  sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        for (String line : reader.lines().collect(Collectors.toList())) {
          sb.append(line);
        }
          System.out.println("\n" + sb + "\n");
/* ====================================================================================================== */
        JSONObject jo = new JSONObject(sb.toString());
        long accountId = jo.getLong("accountId");
        queryMatchList = "match/v3/matchlists/by-account/" + accountId + "?endIndex=10" + "&api_key=";
        urlString = END_POINT + queryMatchList + API_KEY;
        url = new URL (urlString);
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        sb = new StringBuilder();
        for (String line : reader.lines().collect(Collectors.toList())) {
          sb.append(line);
        }
        jo = new JSONObject(sb.toString());
        JSONArray ja = jo.getJSONArray("matches");
        for (int i = 0; i < ja.length(); i++) {
            JSONObject match = ja.getJSONObject(i);
            System.out.println("GameId: "+ match.getLong("gameId") + "\n");

        }
/* ====================================================================================================== */

        long matchId;
        int pID;
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        for (int i = 0; i < ja.length(); i++){
            JSONObject matchStats = ja.getJSONObject(i);
            queryMatchStats = "match/v3/matches/" + matchStats.getLong("gameId") + "?api_key=";
            urlString = END_POINT + queryMatchStats + API_KEY;
            url = new URL (urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            sb = new StringBuilder();
            int u = 0;

            for (String line : reader.lines().collect(Collectors.toList())) {

                sb.append(line);
                jo = new JSONObject(sb.toString());
                JSONArray participants = (jo.getJSONArray("participants"));
                JSONArray participantIdentities = (jo.getJSONArray("participantIdentities"));

                for (int x = 0; x < participantIdentities.length(); x++) {
                  if (participantIdentities.getJSONObject(x).getJSONObject("player").getString("summonerName").equals(summonerName)) {
                      pID = participantIdentities.getJSONObject(x).getInt("participantId");
                      for (int y = 0; y < participants.length(); y++) {
                        if (participants.getJSONObject(y).getInt("participantId") == (pID)) {
                          System.out.println("pID: " + pID + " summoner:" + summonerName  + "\nkills:: "   + participants.getJSONObject(y).getJSONObject("stats").getInt("kills")
                                                                                          + "\ndeaths: "   + participants.getJSONObject(y).getJSONObject("stats").getInt("deaths")
                                                                                          + "\nassists: "  + participants.getJSONObject(y).getJSONObject("stats").getInt("assists") + "\n");
                        }
                      }
                    } else {
                  //  System.out.println("Player not found");
                }
              }
            }
          }
        } catch (Exception e) {
            e.printStackTrace();
    }
  }

  public  void  MatchList() {
   System.out.println(END_POINT + query);
  }
}
