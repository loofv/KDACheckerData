#!/bin/bash

javac -cp "www/WEB-INF/lib/org.json.jar;src" -d www/WEB-INF/classes/ src/org/main/Main.java && java -cp "www/WEB-INF/lib/org.json.jar;www/WEB-INF/classes" org.main.Main
