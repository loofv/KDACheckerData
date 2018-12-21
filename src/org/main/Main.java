package org.main;

import org.net.Match;
import org.net.Match;
import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {

   Match m = new Match();
   //ArrayList<String> statsList = m.getStatsList("w8%204%20gr8%20l8%20m8");
   ArrayList<String> statsList = m.getStatsList("Justicebieber");
    for (int i =0; i<statsList.size(); i++) {
      System.out.println("Kda was: " + statsList.get(i));

    }
  }
}
