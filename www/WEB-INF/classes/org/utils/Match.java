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

//import static javax.json.JsonValue.ValueType.*;
/*
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.json.JsonReader;*/
//import javax.json.*;


public class Match {

  KeyReader kr = new KeyReader();
  private final String        API_KEY   = kr.readKey();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/";
  private String              query;     //= ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader
  private String              sep       = System.getProperty("file.separator");
  private String              jsonPath  = System.getProperty("user.home")
                                                              + sep + "json" + sep + "testMatchIdentities.json";

/*
  public void JsonParser () {
    try{
        JsonReader reader     = Json.createReader( new FileReader(jsonPath) );
        JsonStructure jsonStruct = reader.read();

        if (jsonStruct.getValueType().equals(OBJECT)) {
          System.out.println("Casting to JsonObject...");
          JsonObject jo = (JsonObject) jsonStruct;
          //System.out.println("Summonername: " + jo.getString("summonerName"));

          final String test1 = jo.toString();
          System.out.println(test1); // För att see att test1 får ett värde från JSON

        }
    }catch(JsonException | FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage() + "\n" + jsonPath );
    }
  }
  */
  public void GetStats() {

    String queryAccountId;
    String queryMatchList;
    String queryMatchStats;
    String urlString;

    try {

        queryAccountId = "summoner/v3/summoners/by-name/loofv?api_key=";
        urlString = END_POINT + queryAccountId + API_KEY;
        URL url = new URL (urlString);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        for (String line : reader.lines().collect(Collectors.toList())) {
          sb.append(line);
        }
        System.out.println(sb);
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
            System.out.println("GameId: "+ match.getLong("gameId"));
        }

        /*
        (new InputStreamReader(url.openStream()));
        System.out.println("junior funkar:" + jr.toString());
        int accountId;
        JsonStructure jsonStruct = jr.read();
        JsonObject jo = (JsonObject) jsonStruct;
        String name = jo.getString("name");
        accountId = jo.getInt("accountId");
        System.out.println("name: " + name + " accountId: " + accountId);


        String urlString2 = END_POINT + queryMatchList + API_KEY;
        System.out.println("why be problem?: " + urlString2);
        URL url2 = new URL (urlString2);
        JsonReader jr2 = Json.createReader(new InputStreamReader(url2.openStream()));
        System.out.println("junior2 funkar:" + jr2.toString());
        JsonStructure jsonStruct2 = jr2.read();
        JsonObject jo2 = (JsonObject) jsonStruct2;
        System.out.println("\n\n" + jo2.toString());
*/

/*
        JsonArray ja = new JsonArray (jo2);
        ArrayList <Integer> matchList = new ArrayList<>();
        for (int i = 0; i < ja.size(); i++) {
        }
*/
      /*
        ArrayList <Integer> matchList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i <jo2.getJsonObject(MatchlistDto).getInt("gameId"); i++) {
          matchList.add(jo2.getInt("gameId"));
          j++;
          System.out.println(matchList.get(i));
        }
        */






      } catch (Exception e) {
            e.printStackTrace();
    }
  }


  public  void  MatchList() {
   System.out.println(END_POINT + query);
//   System.out.println(test1);
  }

}
