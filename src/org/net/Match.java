package org.net;

import org.utils.Calculator;

import org.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.util.stream.Collectors;
import java.net.*;
import org.json.*;

public class Match {

  KeyReader kr = new KeyReader();
  private final String        API_KEY   = kr.readKey();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/";

public ArrayList<String> getStatsList(String summonerName) {
  ArrayList<String> statsList = new ArrayList<>();
  Calculator c = new Calculator();
  String queryAccountId;
  String queryMatchList;
  String queryMatchStats;
  String urlString;

  try {
      queryAccountId = "summoner/v3/summoners/by-name/"+ summonerName +"?api_key=";
      urlString = END_POINT + queryAccountId + API_KEY;
      URL url = new URL (urlString);
      StringBuilder  sb = new StringBuilder();
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      for (String line : reader.lines().collect(Collectors.toList())) {
        sb.append(line);
      }

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
                if (participantIdentities.getJSONObject(x).getJSONObject("player").getInt("currentAccountId")==accountId) {
                    pID = participantIdentities.getJSONObject(x).getInt("participantId");
                    for (int y = 0; y < participants.length(); y++) {
                      if (participants.getJSONObject(y).getInt("participantId") == (pID)) {
                        int kills = participants.getJSONObject(y).getJSONObject("stats").getInt("kills");
                        int assists = participants.getJSONObject(y).getJSONObject("stats").getInt("assists");
                        int deaths =  participants.getJSONObject(y).getJSONObject("stats").getInt("deaths");

                        double kda = c.calculateKda(kills, deaths, assists);
                        statsList.add(String.valueOf(kda));
                      }
                    }
                  }
                }
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
      }
      return statsList;
    }
}
