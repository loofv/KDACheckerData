package org.utils;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class KeyReader  {

  String key;
//String sep = System.getProperty("file.separator");
  //String KEY_PATH = "c:\\Cygwin64\\" + System.getProperty("user.home") + sep +
  String KEY_PATH = "key.txt";

  public String readKey () /*throws FileNotFoundException^*/ {

//    System.out.println(KEY_PATH);
    key = "Could not read file content";

    try {
    // pass the path to the file as a parameter
      File file =
        new File(KEY_PATH);
      Scanner sc = new Scanner(file);
      key = sc.nextLine();
      sc.close();
  } catch  (FileNotFoundException fnfe) {
      System.err.println(fnfe.getMessage() + "File not found");
      }

    return key;
  }
}
