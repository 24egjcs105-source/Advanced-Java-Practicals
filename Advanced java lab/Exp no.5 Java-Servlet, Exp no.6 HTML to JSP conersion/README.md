# Experiment 2: Java Servlet

## Aim
To study server-side programming with Java Servlet and implement HTTP request handling, Servlet lifecycle concepts, session handling, and filters.

## Features
- HelloServlet using `doGet()`
- Login form using `doPost()`
- Session creation and username storage
- Authentication filter protecting `/home`
- Logout using `session.invalidate()`
- Servlet context listener
- Maven WAR packaging for Tomcat 11

## Requirements
- JDK 17 or later
- Apache Maven
- Apache Tomcat 11

## Run
1. Open this folder in VS Code or a terminal.
2. Run `mvn clean package`.
3. Copy `target/servlet.war` to Tomcat 11's `webapps` folder.
4. Start Tomcat.
5. Open `http://localhost:8080/servlet/`.

## Demo login
- Username: `admin`
- Password: `1234`

> This fixed credential is for classroom demonstration only. Do not use it in a real application.

## Main structure
- `src/main/java/com/servlet/` — Java Servlet classes, filter, and listener
- `src/main/webapp/` — HTML page
