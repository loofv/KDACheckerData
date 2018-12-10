/*package org.utils;

import java.io.*;
import java.util.Scanner;

public  class KeyReader2 {

  private String currentKey;

  public String readKeyReader2 () {




  //  currentKey = sc.next();

    try {
        Scanner sc = new Scanner (new FileReader("key.txt"));
          currentKey = sc.next();
          System.out.println("currentKey:" + currentKey);
        }catch (FileNotFoundException e) {
          System.err.println(e + "Error - scanner file not found and stuff");
        }

    return currentKey;


  }

}
*/
