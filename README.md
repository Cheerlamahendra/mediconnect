# 🏥 MediConnect – Digital Health Records & Appointment System

## 📌 Overview

MediConnect is a lightweight digital healthcare management system designed for small RMP clinics and hospitals.

It enables:

- 👤 Patient Registration & Login  
- 🏥 Clinic Registration & Login  
- 👨‍⚕ Doctor Management  
- 📅 Appointment Booking with Slot Validation  
- 💳 Simulated Payment Integration  
- 📋 Appointment Tracking  

This system helps clinics operate digitally without complex infrastructure.

---

## 🚀 Features

### 👤 Patient Module
- Patient Registration (Aadhaar validation)
- Secure Login
- View appointments by Patient ID

### 🏥 Clinic Module
- Clinic Registration
- Clinic Login
- View appointments by Clinic ID

### 👨‍⚕ Doctor Module
- Add doctors to clinic
- Assign doctors for appointments
- 10-minute slot-based scheduling

### 📅 Appointment Module
- Prevent double booking
- Check doctor slot availability
- Auto-generate 10-minute time slots
- Appointment statuses:
  - PENDING
  - CONFIRMED
  - CANCELLED

### 💳 Payment Module
- Simulated payment system
- Default consultation fee: ₹100
- Appointment confirmed only after successful payment

---

## 🏗️ Project Architecture (MVC)

Controller → Service → Repository → Database

- Controller → Handles API requests  
- Service → Business logic  
- Repository → Database access  
- Entity → Database tables  
- DTO → Request & Response objects  

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Railway (Backend Deployment)
- Vercel (Frontend Deployment)

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

git clone https://github.com/your-username/mediconnect.git  
cd mediconnect  

---

### 2️⃣ Configure Database

Update `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/mediconnect  
spring.datasource.username=root  
spring.datasource.password=yourpassword  
spring.jpa.hibernate.ddl-auto=update  

---

### 3️⃣ Run Application

mvn clean install  
mvn spring-boot:run  

Application runs at:

http://localhost:8080  

If context path enabled:

http://localhost:8080/mediconnect  

---

## 📡 API Endpoints

### 🔹 Book Appointment

POST /api/appointments/book  

---

### 🔹 Get Appointments by Patient

GET /api/appointments/patient/{patientId}  

---

### 🔹 Get Appointments by Clinic

GET /api/appointments/clinic/{clinicId}  

---

## 🗄️ Database Tables

### Patient
- id
- name
- phoneNumber
- email
- aadhaarNumber
- gender
- age
- address
- bloodGroup
- password

### Clinic
- id
- hospitalName
- email
- contactNumber
- address
- password

### Doctor
- id
- name
- specialization
- clinic_id (FK)

### Appointment
- id
- appointmentDate
- startTime
- endTime
- amount
- paymentStatus
- appointmentStatus
- patient_id (FK)
- clinic_id (FK)
- doctor_id (FK)

---

## 🔐 Security Best Practices

- Aadhaar uniqueness validation
- Slot-based double booking prevention
- API keys stored as environment variables
- No secrets committed to Git

---

## 🌍 Deployment

Backend: Railway  
Frontend: Vercel  

---

## 📌 Future Enhancements

- Razorpay Integration
- JWT Authentication
- Admin Dashboard
- Email/SMS Notifications
- Pagination & Filtering
- Role-based Access Control

---

## 👨‍💻 Author

Mahendra Cheerla  
Spring Boot Backend Developer
