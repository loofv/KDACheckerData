package org.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.FileReader;
import java.util.List;

import java.net.URL;                                  //fixa imports, importerar allt for now.
import java.util.stream.Collectors;
import java.net.*;
import static javax.json.JsonValue.ValueType.*;
/*
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.json.JsonReader;*/
import javax.json.*;


public class Match {

  KeyReader kr = new KeyReader();
  private final String        API_KEY   = kr.readKey();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/";
  private String              query;     //= ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader
  private String              sep       = System.getProperty("file.separator");
  private String              jsonPath  = System.getProperty("user.home")
                                                              + sep + "json" + sep + "testMatchIdentities.json";
  private String queryAccountId;
  private String queryMatchList;
  private String queryMatchStats;
  private String urlString;
  private String SummonerName;
  private int    accountId;
/*  private String urlString;

  public String summonerName;
  public int accountId;
  public List <int> MatchList<>;
  public int kills;
  public int deaths;
  public int assists;
  public double kda; */


  //public String test1 = "THIS SHOULD BE OVERWRITTEN";

  public void JsonParser () {
    try{
        JsonReader reader     = Json.createReader( new FileReader(jsonPath) );
        JsonStructure jsonStruct = reader.read();

        if (jsonStruct.getValueType().equals(OBJECT)) {
          System.out.println("Casting to JsonObject...");
          JsonObject jo = (JsonObject) jsonStruct;
          //System.out.println("Summonername: " + jo.getString("summonerName"));

        //  final String test1 = jo.toString();
        //  System.out.println(test1); // För att see att test1 får ett värde från JSON

        }
    }catch(JsonException | FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage() + "\n" + jsonPath );
    }
  }

  public void GetStats() {
   //flytta upp dessa?
  /*  String queryAccountId;
    String queryMatchList;
    String queryMatchStats;
    String urlString;
    int accountId;*/

    /* Use accountId to get matchList, put matchIds in an arraylist or other list.
       iterate over that list of matchIds to get stats for all those matches.
       Put those stats into a kda-arraylist or other List */

    try {
        queryAccountId = "summoner/v3/summoners/by-name/loofv?api_key="; //hardcoded for account: loofv
        urlString      = END_POINT + queryAccountId + API_KEY;
        URL url        = new URL (urlString);
        JsonReader jr  = Json.createReader(new InputStreamReader(url.openStream()));
        System.out.println("junior funkar: " + jr.toString());

        JsonStructure jsonStruct = jr.read();
        JsonObject jo = (JsonObject) jsonStruct;
        SummonerName  = jo.getString("name");
        accountId     = jo.getInt("accountId");
        System.out.println("name: "
                              + SummonerName
                                + "\n"
                                  + "accountId: "
                                    + accountId);
      } catch (Exception e) {
            e.printStackTrace();
    }
  }

  public  void  MatchList() {
   System.out.println(END_POINT + query);
//   System.out.println(test1);
  }

}
