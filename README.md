Detailed step list to get the application up an running:
--------------------------------------------------------

1. Download Apache Tomcat (9.0.27) https://tomcat.apache.org/download-90.cgi
2. Update the configuration files (https://github.com/julianpicon/Portfolio_Web/tree/master/Apache%20Tomcat)
3. Copy the application WAR file to the server's Webapps folder
4. Start Apache Tomcat
5. Go to http://localhost:8080/zemoga/portfolio/{twitterUserName}

Software prerequisites:
-----------------------

1. Apache Tomcat 9.0.27 (updated server.xml and context.xml files)
2. JDK 11
3. Maven

Steps to build the app:
-----------------------

1. Use the IDE (IntelliJ) to generate the WAR or 
1. Use the maven (clean / install) commands to generate the distributables (war).

Total time: 14 