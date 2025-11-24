# **MyTour**

MyTour is a mobile application that delivers self-guided, multimedia-rich tours created by local experts. Travelers can explore destinations independently using interactive maps, GPS-triggered content, and a curated marketplace of free and paid tours.

---

## **Executive Summary**

Traditional guided tours offer valuable information but lack flexibility, forcing travelers to follow fixed schedules and content. Many travelers prefer independent exploration while still benefiting from expert local knowledge.

MyTour addresses this need by providing a mobile platform where users can discover, purchase, and follow self-guided tours enriched with interactive maps and multimedia content at points of interest (POIs). Guides can create and publish tours through an integrated creation system. The goal is to deliver a personalized, autonomous travel experience for independent-minded explorers worldwide.

## **Core Features**

- Role-based authentication for travelers and guides
- Travelers select a location and browse available tours.
- Each tour includes a mapped route and multimedia content triggered at POIs.
- Guides can create tours, upload multimedia content, and assign themes.
- Personalized dashboards for both roles
- Tour creation tools for guides



## **Tech Stack**

**Backend**

- Java Spring Boot
- PostgreSQL
- JWT Authentication

**Frontend**

- React Native
- REST API integration

---

## **Screenshots**

### Authentication

Signup & Login

<p align="center">
  <img src="screenshots/signupscreen.png" width="260" />
  <img src="screenshots/loginscreen.png" width="260" />
</p>

---

### Creating a Tour

Create Tour & Pick Location

<p align="center">
  <img src="screenshots/creatingtour.png" width="260" />
  <img src="screenshots/pickinglocation.png" width="260" />
</p>

---

### Browsing Tours

Explore All Tours & Explore a Single Tour

<p align="center">
  <img src="screenshots/exploringtours.png" width="260" />
  <img src="screenshots/exploringtour.png" width="260" />
</p>

---

### Following a Tour

Following & Enjoying a Tour

<p align="center">
  <img src="screenshots/followingtour.png" width="260" />
  <img src="screenshots/enjoyingtour.png" width="260" />
</p>

---


## 📦 **Installation**

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm start
```

---

