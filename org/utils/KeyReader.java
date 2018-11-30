package org.utils;

import java.io.*;
import java.util.Scanner;

public  class KeyReader {

  private static String currentKey;

  private String FileScanner (String currentKey) throws FileNotFoundException {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner (new FileReader("key.txt"));

    try {
        while(sc.hasNext()){ sb.append(sc.next());}
            currentKey = sc.toString();
            sc.close();
        }catch (Exception e) {
          System.err.println(e + "Error - scanner file not found and stuff");
        }

    return currentKey;
  }
  public  String getCurrentKey(){
    //  return currentKey.toString();
    return "testar felsoekning";
    }

}
