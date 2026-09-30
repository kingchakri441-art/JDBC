# Student Management System

## Stack
- HTML, CSS, JavaScript
- Node.js + Express (serves frontend)
- Java 17 + Spring Boot
- Spring JDBC / JDBC
- MySQL

## 1. Database
Run `database.sql` in MySQL.
Then edit `java-backend/src/main/resources/application.properties` and set your MySQL password.

## 2. Java backend
Requirements: Java 17+ and Maven.

Open a terminal:
cd java-backend
mvn spring-boot:run

Backend: http://localhost:8080

## 3. Node.js frontend server
Requirements: Node.js.

Open another terminal:
cd node-server
npm install
npm start

Frontend: http://localhost:3000

## 4. Test
Open http://localhost:3000
Add, edit, and delete students.

Architecture:
Browser -> Node/Express -> frontend files
Browser JavaScript -> REST API -> Spring Boot -> JDBC -> MySQL
