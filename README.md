# Spring Boot Bootcamp

A hands-on Java and Spring Boot learning repository focused on strengthening programming fundamentals, understanding object-oriented design, and building backend applications.

This repository contains practice projects, coding exercises, and experiments as I progress through my Java and Spring Boot learning journey.

## 🚀 Technologies

- **Language:** Java
- **Backend Framework:** Spring Boot
- **Build Tool:** Apache Maven
- **Java Version:** JDK 21
- **IDE:** IntelliJ IDEA
- **Database Connectivity:** MySQL Connector/J (in the relevant Maven project)
- **Version Control:** Git and GitHub

## 📚 Projects

### 1. CoreDemo — Notification Services

A Java project demonstrating object-oriented programming and interface-based design through an order-processing example.

**Concepts covered:**
- Interfaces and implementations
- Abstraction and polymorphism
- Separation of responsibilities
- Email, SMS, and pop-up notification services
- Service-to-service interaction

The `OrderService` uses a `NotificationService` interface to send a notification when an order is placed.

### 2. MavenDemo — Maven Fundamentals

A practice project for exploring Java application structure and Maven dependency management.

**Concepts covered:**
- Maven project structure
- `pom.xml` configuration
- Dependency declaration
- Java application basics
- MySQL Connector/J dependency

### 3. Spring Boot Demo — REST Endpoints

A Spring Boot web application for practising basic HTTP endpoints using Spring MVC.

**Current examples:**

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/hello` | Returns a Hello World response |
| GET | `/bye` | Returns a Bye response |

The application is configured to use port `9090`.

Example local URL: `http://localhost:9090/hello`

## 🛠️ Getting Started

### Prerequisites

- JDK 21, or the JDK version specified by the individual project
- IntelliJ IDEA or another Java IDE
- Git
- Maven, or the Maven Wrapper included with the relevant project

### Clone the Repository

```bash
git clone https://github.com/VamsiKrishna-9443/SpringBoot-BootCamp.git
cd SpringBoot-BootCamp
```

### Open a Project

1. Open the repository in IntelliJ IDEA.
2. Locate the project you want to run.
3. Open its `pom.xml` as a Maven project.
4. Set the appropriate JDK.
5. Allow Maven to download the required dependencies.

### Run the Spring Boot Application

Open a terminal in the Spring Boot project's directory and run:

**Windows — Maven Wrapper available:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux — Maven Wrapper available:**

```bash
./mvnw spring-boot:run
```

Alternatively, use `mvn spring-boot:run` if Maven is installed and configured.

Once the application starts, visit `http://localhost:9090/hello` in your browser.

## 🎯 Learning Objectives

- Strengthen Java and object-oriented programming fundamentals.
- Understand interfaces, abstraction, and polymorphism.
- Develop familiarity with Maven and dependency management.
- Build REST endpoints using Spring Boot.
- Practise organizing backend code into maintainable components.
- Gradually expand into database integration, Spring Data JPA, validation, and application testing.

## 📈 Progress

This repository is continuously updated as I learn new concepts and complete exercises. Each project represents part of my ongoing journey toward becoming a Java Backend and Spring Boot Developer.

## 👨‍💻 Author

**Vamsi Krishna Yadav**

- GitHub: [@VamsiKrishna-9443](https://github.com/VamsiKrishna-9443)

---

*Learn. Build. Test. Improve.*
