# Spring Boot CRM System

A Customer Relationship Management (CRM) application built using Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA, and MySQL.

## Features

* Add Customer
* View All Customers
* Delete Customer
* Customer Details Management
* MySQL Database Integration
* Thymeleaf UI

## Tech Stack

* Java
* Spring Boot
* Spring MVC
* Thymeleaf
* Spring Data JPA
* MySQL
* Maven

## Project Structure

src
├── controller
├── service
├── repository
├── entity
├── templates

## Database Configuration

Update the database credentials in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/crmdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

## Application Flow

Customer Form

↓

Save Customer

↓

View Customer List

↓

Delete Customer

## Learning Outcomes

* MVC Architecture
* Thymeleaf Templates
* Spring Data JPA
* Dependency Injection
* CRUD Operations
* Database Integration

## How to Run

1. Create MySQL database:

CREATE DATABASE crmdb;

2. Update database credentials

3. Run:

CrmappApplication.java

4. Open:

http://localhost:8080

## Author

Vishal Singh
