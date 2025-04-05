# ✈️ Yash Airways - Airline Reservation System

A complete, production-ready backend system for an Airline Reservation platform built using **Spring Boot**, **MongoDB**, **JWT**, and deployed on **Railway**. It provides APIs for user registration, flight search, booking, ticket generation, email notifications, and scheduled ticket cleanup.

> 🔗 **Live API Base URL**: [https://yashairways-reservation-system-production.up.railway.app/check].

---

## 📦 Features

- 🔐 Spring Security & Role-based Authorization
- 🧑‍💻 Secure User & Admin management
- ✈️ Flight Search, Booking, and Seat Management
- 🎟 PDF Ticket Generation (Styled with Logo and Tables)
- 📧 Email Notifications (Sign-up & Ticket with PDF)
- 🧹 Daily Cleanup of Expired Tickets (Scheduled Task)
- ☁️ Deployment on Railway with Docker Support

---

## ⚙️ Tech Stack

| Layer       | Technology                  |
|------------|-----------------------------|
| Backend     | Spring Boot (Java 17)       |
| Database    | MongoDB + MongoDB Atlas     |
| Security    | Spring Security             |
| PDF         | iText                       |
| Email       | JavaMailSender (SMTP)       |
| Deployment  | Railway                     |
| Build Tool  | Maven                       |

---

cinfigure properties

# MongoDB
spring.data.mongodb.uri=${MONGO_URI}

# Email
spring.mail.username=${EMAIL_USERNAME}
spring.mail.password=${EMAIL_PASSWORD}

# Server
server.port=8080

📬 Email Features
Welcome Email on Signup

Ticket Confirmation Email with PDF Ticket Attached

Uses Gmail SMTP or any custom SMTP server


🧼 Auto Ticket Cleanup
A scheduled task runs every 24 hours:

Finds all past journey tickets

Deletes them from the database

Keeps your system lean and fast


🧾 PDF Ticket Generation
After booking, a professional airline-style ticket is auto-generated:

Styled with logo, colors, and tables

Includes passenger, flight, and seat details

Generated using iText

Attached to confirmation email



## Author 
Yash Gupta
📧 guptay264@gmail.com
📱 +91 7748965563


