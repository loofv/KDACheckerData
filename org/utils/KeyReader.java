package utils;

import java.io.*;
import java.util.Scanner;

public class KeyReader {

  public static String currentKey;

  private String FileScanner (String currentKey) throws FileNotFoundException {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner (new FileReader("api_key.txt"));
    try {
        while(sc.hasNext()){ sb.append(sc.next());}
            currentKey = sc.toString();
            sc.close();
        }catch (Exception e) {
          System.err.println(e + "Error - scanner file not found and stuff");
        }
    //this.currentKey=currentKey;
    /*catch (FileNotFoundException fnfe){
      System.err.println(fnfe + "File not found");
    }*/
    return currentKey;
  }
  public static String getCurrentKey(){
      return currentKey.toString();
    }

}
