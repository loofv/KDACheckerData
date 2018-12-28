package servlets;

import java.util.ArrayList;
import org.net.Match;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import org.json.*;
import java.lang.NullPointerException;
public class KDAServlet extends HttpServlet {

 @Override
 public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
   request.setCharacterEncoding(UTF_8.name());
  // response.setContentType("text/html;charset="+UTF_8.name()); //text/html
   PrintWriter out =
     new PrintWriter(new OutputStreamWriter(response.getOutputStream(),
                                            UTF_8), true);

   response.setContentType("application/json");
   try {
   String summonerName = request.getParameter("name");
   Match m = new Match();

   if (summonerName == null)  {
     System.out.println("Något gick fel, kontrollera stavning. ");
     JSONArray ja = new JSONArray();
     ja.put("null summonername given.");
     out.println(ja);
   } else {
   ArrayList<String> statsList = m.getStatsList(summonerName);
    System.out.println("vad försnmame" + summonerName);
   JSONArray ja = new JSONArray();

   for (String kda : statsList) {
     ja.put(kda);
     System.out.println(kda);
   }

   out.println(ja);
    

 } //else sats slutar

 } catch (NullPointerException npe) {
   System.err.println(npe.getCause().getMessage());
 }




    //toString(2)
   /*
   out.println("<!DOCTYPE html>");
   out.println("<html lang=\"en\">");
   out.println("<head><title>KDAChecker</title></head>");
   out.println("<body>");
   out.println("<h1>KDAChecker is DOWN! for now.</h1>");
   out.println(statsList);
   out.println("</body>");
   out.println("</html>");
   //m.JsonParser();
   */
 }
}
