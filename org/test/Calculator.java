package org.test;

import java.lang.Math;

public class Calculator {

  public int kills;
  public int deaths;
  public int assists;
  public double kda;

  public double calculateKda (int kills, int deaths, int assists) {
    double k = kills;
    double d = deaths;
    double a = assists;

// smått grisig if-sats, finns troligen bättre lösning.
    if (d == 0.0) {
      System.out.println("Your kda is perfect! (100)");
      kda = 100.0; //sätter kda 100 om man inte dör. annan lösning?
      return kda;
    } else {
    kda = ((k + a) / d);
    kda = Math.floor(kda * 100) / 100; //begränsar kda till två decimaler.  
    return kda;
    }
  }

  public static void main (String[] args) {
    Calculator c = new Calculator();
    double kda;
    kda = c.calculateKda(14, 3, 3);
    System.out.println("Din kda är: " + kda);
  }
}
