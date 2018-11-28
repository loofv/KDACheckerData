package utils.rw;

import java.io.*;
import java.util.Scanner;

public class KeyReader {

  public String currentKey;

  public KeyReader (String currentKey) throws FileNotFoundException {
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
  }
  public String getCurrentKey(){
      return currentKey.toString();
    }

}
