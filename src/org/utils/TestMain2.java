package org.utils;

import org.net.Match;
//import org.utils.Match;
//import org.utils.KeyReader;
import java.util.ArrayList;


public class TestMain2 {


  public static void main (String[] args) {
   Match m = new Match();
//m.MatchList();
    //m.JsonParser();
    //m.GetStats();

    ArrayList<String> statsList = m.getStatsList();
    for (int i =0; i<statsList.size(); i++) {
      System.out.println("Kda was: " + statsList.get(i));
    }
  }
}
