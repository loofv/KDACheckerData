package org.net;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class KeyReader  {

  String key;
  String KEY_PATH = "key.txt";
<<<<<<< HEAD
  //key.txt ska ligga i huvudkatalogen
=======
>>>>>>> a5b328dc914b95c1906a72688ebef1520db0bd67
  public String readKey () {
    key = "Could not read file content";

    try {
      File file  = new File(KEY_PATH);
      Scanner sc = new Scanner(file);
      key = sc.nextLine();
      sc.close();
  } catch  (FileNotFoundException fnfe) {
      System.err.println(fnfe.getMessage() + "File not found");
      }
    return key;
  }
}
