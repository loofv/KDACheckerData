/*package org.utils;

import java.io.*;
import java.util.Scanner;

public  class KeyReader {

  private String currentKey;

  private String FileScanner () throws FileNotFoundException {
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
*/
package org.utils;


/* import java.io.*;
import java.util.Scanner;

public  class KeyReader {

  private String currentKey;

  public String readKeyReader2 () {




  //  currentKey = sc.next();

    try {
      File file = new File ("C:\\cygwin64\\home\\loveh\\KDACheckerData\\key.txt");
        Scanner sc = new Scanner (file);
          currentKey = sc.next();
          while (sc.hasNextLine()) {
            System.out.println("Ocars while:" + sc.next());

          }
          sc.close();
          System.out.println("currentKey:" + currentKey);
        }catch (FileNotFoundException e) {
          System.err.println(e + "Error - scanner file not found and stuff");
        }

    return this.currentKey=currentKey;


  }

}
*/

// Java Program to illustrate reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class KeyReader
{
  String pelle;
  String sep = System.getProperty("file.separator");
  //String KEY_PATH = "c:\\Cygwin64\\" + System.getProperty("user.home") + sep +
  String KEY_PATH = "key.txt";

  public String readKeyReader2 () /*throws FileNotFoundException^*/ {
    System.out.println(KEY_PATH);
    pelle = "fan funka inte";
    try {
    // pass the path to the file as a parameter
    File file =
      new File(KEY_PATH);
    Scanner sc = new Scanner(file);
    pelle = sc.nextLine();
  //  System.out.println(sc.nextLine());
    /*while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
      pelle = sc.nextLine();
    }*/ sc.close();
  } catch  (FileNotFoundException fnfe) {

  System.err.println(fnfe.getMessage() + "FEL");
      }
    return pelle;
  }
}
