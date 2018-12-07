package org.utils;

//import Player;
//import org.utils.KeyReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.FileReader;
//import java.util.Scanner;
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
  private final String        API_KEY   = kr.readKey(); //readKeyReader2();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
  private final String        QUERY     = ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader

  public String jsonPath = "..\\..\\json\\testMatchIdentities.json";
  public void JsonParser () /*throws FileNotFoundException*/ {
    try{
        JsonReader reader     = Json.createReader( new FileReader(jsonPath) );
        JsonStructure jsonStruct = reader.read();

        if (jsonStruct.getValueType().equals(OBJECT)) {
          System.out.println("Casting to JsonObject...");
          JsonObject jo = (JsonObject) jsonStruct;
          System.out.println("Summonername: " + jo.getString("summonerName"));
        }
    }catch(JsonException | FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage());
    }
  //    JsonArray() jarr = jo.getJsonArray("");

  }

  public  void  MatchList() {

   System.out.println(END_POINT + QUERY);

  }


  //int gameID;
  //ArrayList <Player> players;
}
