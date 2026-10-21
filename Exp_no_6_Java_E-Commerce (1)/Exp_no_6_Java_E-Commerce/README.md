# Exp No. 6 — Java E-Commerce (ShopSphere)

A beginner-friendly Java web application built with **Java, Jakarta Servlets, JSP, Maven and Apache Tomcat 11**.

## Features
- Product catalogue with six demo products
- Add items to cart
- Increase/decrease quantities and remove items
- Automatic subtotal and total calculation
- Demo checkout form and order confirmation
- Responsive CSS layout
- Cart is stored in the HTTP session (no database required)

## Requirements
- JDK 17 or newer (Java 21 is fine)
- Apache Maven 3.9+ (Maven 3.10 is fine)
- Apache Tomcat 11

## Build
Open this project folder in VS Code. In the terminal, run:

```powershell
& "$env:USERPROFILE\Downloads\apache-maven-3.10.0-bin\apache-maven-3.10.0\bin\mvn.cmd" clean package
```

The WAR file will be created at `target\ecommerce.war`.

## Run on Tomcat 11
1. Start Tomcat:

```powershell
$tomcat = "$env:USERPROFILE\Downloads\apache-tomcat-11.0.27\apache-tomcat-11.0.27"
& "$tomcat\bin\startup.bat"
```

2. Copy the WAR to Tomcat's webapps folder:

```powershell
Copy-Item ".\target\ecommerce.war" "$tomcat\webapps\ecommerce.war" -Force
```

3. Open: http://localhost:8080/ecommerce/

If Tomcat is already running, wait a few seconds for deployment. If it does not redeploy, stop Tomcat, copy the WAR, then start Tomcat again.

## Project structure
```text
Exp no.6 Java E-Commerce/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/ecommerce/
    │   ├── model/       Product.java, CartItem.java
    │   ├── servlet/     HomeServlet.java, CartServlet.java, CheckoutServlet.java
    │   └── util/        ProductStore.java
    └── webapp/
        ├── assets/style.css
        └── WEB-INF/views/ home.jsp, cart.jsp, checkout.jsp, success.jsp
```

## Notes for lab submission
This is a functional demonstration project. It does not include database persistence, real authentication, payment processing, or saved order history. The checkout is a demo only and does not charge money.
