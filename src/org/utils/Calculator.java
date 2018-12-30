package org.utils;

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

<<<<<<< HEAD

    if (d == 0.0) {
      System.out.println("Your kda is perfect! (100)");
      kda = 100.0; //sätter kda 100 om man inte dör.
      return kda;
    } else {
    kda = ((k + a) / d);
    kda = Math.floor(kda * 100) / 100; //begränsar kda till två decimaler.
    return kda;
=======
    if (d == 0.0) {
        System.out.println("Your kda is perfect! (100)");
        kda = 100.0;
        return kda;
      } else {
        kda = ((k + a) / d);
        kda = Math.floor(kda * 100) / 100;
        return kda;
>>>>>>> a5b328dc914b95c1906a72688ebef1520db0bd67
    }
  }
}
