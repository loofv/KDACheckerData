package org.utils;

//import Player;
//import KeyReader;
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

  KeyReader kr = new KeyReader();
  private final String        API_KEY   = kr.readKey(); //readKeyReader2();
  private static final String END_POINT = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
  private final String        QUERY     = ("34158466?api_key="+ API_KEY); //Insert API Key from KeyReader


  public  void  MatchList() {

   System.out.println(END_POINT + QUERY);

  }


  //int gameID;
  //ArrayList <Player> players;
}
