# 🏫 CampusCare — College Complaint Management System

> A Java-based desktop application designed to digitize the college complaint and grievance management process.

**CampusCare** is a simple College Complaint Management System built using **Java Swing and File Handling**. It provides separate interfaces for **Students, Administrators, and the Principal**, allowing complaints to be submitted, viewed, managed, and tracked through a simple desktop application.

This project was developed as a practical learning project to understand how Java programming concepts can be combined to build a real-world application.

---

## 📌 Project Overview

In many colleges, complaints related to classrooms, electricity, internet, cleanliness, hostel facilities, water, transportation, and other services may be handled manually.

CampusCare provides a simple digital solution where:

* 👨‍🎓 Students can submit and view complaints
* 👨‍💼 Administrators can view and manage complaints
* 🏫 The Principal can monitor complaint statistics
* 📊 Complaint data can be tracked through dashboards
* 💾 Complaint information is stored using file handling

The project focuses on keeping the implementation **simple, understandable, and beginner-friendly** while demonstrating the fundamentals of Java application development.

---

## ✨ Features

### 👨‍🎓 Student Portal

* Student login
* Submit a new complaint
* Select complaint category
* Select complaint priority
* Enter complaint location
* Add detailed complaint description
* Automatic complaint ID generation
* View previously submitted complaints
* View complaint status

### 👨‍💼 Admin Portal

* Admin login
* View all submitted complaints
* View complaint details
* Manage complaints
* Update complaint status
* Monitor complaint statistics

### 🏫 Principal Portal

* Principal login
* View total complaints
* View pending complaints
* View complaints in progress
* View resolved complaints
* View resolution rate
* View category-wise complaint statistics



## 🛠️ Technologies Used

| Technology       | Purpose                             |
| ---------------- | ----------------------------------- |
| ☕ Java           | Core programming language           |
| 🖥️ Java Swing     | Graphical User Interface            |
| 📁 File Handling | Storing and reading complaint data  |
| 🧩 OOP           | Organizing application components   |
| 💻 IntelliJ IDEA | Development environment             |
| 🔧 Git & GitHub  | Version control and project hosting |

---



## 📂 Project Structure


CampusCare
│
├── src
│   └── com.campuscare
│       │
│       ├── Main.java
│       ├── StudentDashboard.java
│       ├── SubmitComplaint.java
│       ├── ComplaintFileManager.java
│       ├── MyComplaints.java
│       │
│       ├── AdminDashboard.java
│       ├── AllComplaints.java
│       ├── ManageComplaint.java
│       │
│       └── PrincipalDashboard.java
│
├── data
│   └── complaints.txt
│
└── README.md


---

## 🗃️ Complaint Data

CampusCare currently uses a simple text file for data storage instead of a database.

Complaint information is stored in:

data/complaints.txt


Each complaint follows this structure:


Complaint ID
Student Name
Category
Location
Priority
Description
Status


Example:
CMP-2026-4821|Om Mishra|Internet / Wi-Fi|Computer Lab|HIGH|Wi-Fi is not working|PENDING


This approach keeps the project easy to understand while demonstrating basic file-based data persistence.

---

## 🎯 Complaint Categories

CampusCare currently supports:

* ⚡ Electrical
* 🌐 Internet / Wi-Fi
* 🧹 Cleanliness
* 🏫 Classroom
* 🛏️ Hostel
* 📚 Library
* 💧 Water
* 🚌 Transport
* 🎓 Academic
* 📌 Other

### Priority Levels


LOW
MEDIUM
HIGH
URGENT


### Complaint Status


PENDING
ASSIGNED
IN_PROGRESS
RESOLVED
REJECTED


---

## 🚀 Getting Started

### Prerequisites

Before running CampusCare, make sure you have:

* Java JDK installed
* IntelliJ IDEA or another Java IDE
* Git (optional, if cloning the repository)

### 1. Clone the Repository


git clone https://github.com/ommishra507/CampusCare---cms.git


### 2. Open the Project

Open the downloaded project in **IntelliJ IDEA**.

### 3. Check the Project Structure

Make sure the Java files are located under:


src/com/campuscare


### 4. Run the Application

Run:
Main.java


This will open the CampusCare login screen.

---

## 🔐 Demo Login

For demonstration purposes, the application currently contains predefined login credentials.

### Student

Email: student@campuscare.com
Password: 123456


### Admin

Email: admin@campuscare.com
Password: admin123

### Principal


Email: principal@campuscare.com
Password: principal123


> ⚠️ These credentials are only for the local demo version of the project and should not be considered production authentication.

---

## 🖥️ Application Modules

### 1. Login

The application starts with a common login screen where users can access the appropriate portal.


Student → Student Dashboard
Admin → Admin Dashboard
Principal → Principal Dashboard


### 2. Student Dashboard

Students can:

* Submit complaints
* View their complaints
* Track complaint status
* Logout

### 3. Submit Complaint

Students provide:


Category
Location
Priority
Description


After submission, CampusCare generates a complaint ID and stores the complaint.

### 4. My Complaints

Students can view complaints submitted under their account in a table format.

### 5. Admin Dashboard

Administrators can monitor:


Total Complaints
Pending Complaints
Resolved Complaints


### 6. Manage Complaint

Administrators can update the status of a complaint:


PENDING
     ↓
ASSIGNED
     ↓
IN_PROGRESS
     ↓
RESOLVED


A complaint may also be marked as:


REJECTED


### 7. Principal Dashboard

The Principal dashboard provides an overview of the complaint system, including:

* Total complaints
* Pending complaints
* Complaints in progress
* Resolved complaints
* Resolution rate
* Category-wise statistics




## 🔮 Future Improvements

CampusCare is currently a **learning-focused desktop prototype**.

Possible future improvements include:

* 🗄️ MySQL database integration
* 🌐 Web-based version using Spring Boot
* 🔐 Secure user authentication
* 👤 User registration
* 📧 Email notifications
* 📱 Mobile-friendly interface
* 🔎 Advanced complaint search and filtering
* 📊 More detailed analytics
* 📝 Persistent admin remarks
* ☁️ Cloud-based deployment

These improvements can make the system more suitable for a real-world college environment.

---

## 🎓 Project Purpose

This project was created as a practical Java learning project and as a college project for **Engineer's Day**.

The main goal was to move beyond simple Java programs and build a complete application with:

> **GUI + User Roles + File Handling + Data Management + Dashboards**

---

## 👨‍💻 Author

### Om Mishra

Computer Science / Engineering Student
Interested in Java, Software Development, Backend Development and AI/ML.



## ⭐ Support

If you found this project interesting or useful, consider giving the repository a ⭐ on GitHub.

Feedback and suggestions are always welcome!

---

## 📄 License

This project is currently intended for **educational and learning purposes**.
