javac -cp "www/WEB-INF/classes/servlets/*.java;www/WEB-INF/lib/*;src/org/net/*.java;www/WEB-INF/classes" -d www/WEB-INF/classes/servlets/ www/WEB-INF/classes/servlets/KDAServlet.java
&& java -jar www/WEB-INF/lib/winstone.jar --webroot=www


//funkar inte så bra hittills
