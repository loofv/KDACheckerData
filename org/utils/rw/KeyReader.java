import java.io*;

public class KeyReader {

  private String currentKey;

  public KeyReader (String currentKey) throws FileNotFoundException {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner (new FileReader("api_key.txt"));
    try {
        while(sc.hasNext()){
          sb.append(in.next());
        }
      sc.close();
      currentKey = sc.toString();  
    }catch (FileNotFoundException fnfe) {
        System.err.println(fnfe + "File not found");
        }
    //this.currentKey=currentKey;

  }
}
