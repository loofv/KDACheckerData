package org.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.FileReader;

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
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
  private final String        QUERY     = ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader
  private String              sep       = System.getProperty("file.separator");
  private String              jsonPath  = System.getProperty("user.home")
                                                              + sep + "json" + sep + "testMatchIdentities.json";
  //public String test1 = "THIS SHOULD BE OVERWRITTEN";

  public void JsonParser () {
    try{
        JsonReader reader     = Json.createReader( new FileReader(jsonPath) );
        JsonStructure jsonStruct = reader.read();

        if (jsonStruct.getValueType().equals(OBJECT)) {
          System.out.println("Casting to JsonObject...");
          JsonObject jo = (JsonObject) jsonStruct;
        //  System.out.println("Summonername: " + jo.getString("summonerName"));

          final String test1 = jo.toString();
          System.out.println(test1); // För att see att test1 får ett värde från JSON
        }
    }catch(JsonException | FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage() + "\n" + jsonPath );
    }


  }

  public  void  MatchList() {
   System.out.println(END_POINT + QUERY);
//   System.out.println(test1);
  }


  //int gameID;
  //ArrayList <Player> players;
}
