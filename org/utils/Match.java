package utils;

//import Player;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.net.URL;
//import javax.json.*;
//fixa imports, importerar allt for now.
import java.util.Scanner;
import java.util.stream.Collectors;
import java.net.*;

public class Match {

  static KeyReader kr = new KeyReader();
  private static       String API_KEY   = kr.getCurrentKey();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
  private static final String QUERY     = ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader

  public String MatchList() {

   System.out.println(END_POINT + QUERY + API_KEY);

    return null;
  }


  //int gameID;
  //ArrayList <Player> players;
}
