# Student Management System - Database Version

## Technology
Frontend:
- HTML
- CSS
- JavaScript

Frontend server:
- Node.js
- Express

Backend:
- Java 17
- Spring Boot
- JDBC / Spring JdbcTemplate

Database:
- MySQL

## How the data flows

HTML Form
    ↓
JavaScript fetch()
    ↓
Java Spring Boot REST API
    ↓
JDBC / JdbcTemplate
    ↓
MySQL students table
    ↓
GET API
    ↓
JavaScript
    ↓
HTML Table

## Step 1 - Create database

Open MySQL Workbench or MySQL command line and run:

database.sql

This creates:

Database: studentdb
Table: students

Columns:
id
name
email
course

## Step 2 - Configure MySQL password

Open:

java-backend/src/main/resources/application.properties

Change:

spring.datasource.password=password

to your actual MySQL password.

If your MySQL username is not root, change that too.

## Step 3 - Start Java backend

Open terminal in:

java-backend

Run:

mvn spring-boot:run

Java API runs at:

http://localhost:8080

## Step 4 - Start Node.js frontend

Open another terminal in:

node-server

Run:

npm install

Then:

npm start

Open:

http://localhost:3000

## Step 5 - Test

Enter:

Name
Email
Course

Click Submit.

The Java backend inserts the information into MySQL using JDBC.

Then JavaScript calls GET /api/students and displays the database records in the table.

Important:
Node.js is serving the frontend. Java Spring Boot is handling the database API and JDBC connection.
