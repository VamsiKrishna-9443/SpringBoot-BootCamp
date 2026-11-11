<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=22&pause=1000&color=6DB33F&center=true&vCenter=true&width=700&lines=Welcome+to+My+Java+%26+Spring+Boot+Journey;Learning+Java+%7C+Exploring+Spring+Core;Building+Backend+Applications+with+Spring+Boot;Learn.+Build.+Test.+Improve." alt="Animated heading: Welcome to My Java and Spring Boot Journey, Learning Java, Exploring Spring Core, Building Backend Applications with Spring Boot, Learn. Build. Test. Improve." />
</p>

<h1 align="center">🌱 Spring Boot Bootcamp</h1>

<p align="center">
  A hands-on Java and Spring Boot learning repository, built one exercise at a time.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring_Framework-7.0.7-6DB33F?logo=spring&logoColor=white" alt="Spring Framework 7.0.7" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 4.1.1" />
  <img src="https://img.shields.io/badge/Apache_Maven-C71A36?logo=apachemaven&logoColor=white" alt="Apache Maven" />
  <img src="https://img.shields.io/badge/MySQL_Connector%2FJ-9.5.0-4479A1?logo=mysql&logoColor=white" alt="MySQL Connector/J 9.5.0" />
  <img src="https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white" alt="Git" />
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?logo=intellijidea&logoColor=white" alt="IntelliJ IDEA" />
  <img src="https://img.shields.io/badge/Status-Learning_in_progress-6DB33F" alt="Status: learning in progress" />
</p>

---

## 📖 About This Repository

This repository holds the code I write while learning Java, the Spring Framework, and Spring Boot. I started it to keep my practice in one place: small projects, each focused on one idea.

It is a work in progress. New modules and exercises are added as I move from Java fundamentals through Spring Core and into REST APIs, databases, and testing.

## 📺 Currently Learning

I'm following the **[Coder Army – Java and Spring Boot Playlist](https://www.youtube.com/watch?v=Q04sTEwC7Kg&list=PLEYgx5hMdopw)**. This repository contains my own implementations and notes from the lectures as I go. I haven't finished the course.

## 🧰 Technologies

| Technology | Where it appears | Documentation |
|---|---|---|
| Java 21 | All modules | [Java docs](https://docs.oracle.com/en/java/) |
| Spring Framework 7.0.7 | `SpringCoreDemo` | [Spring reference](https://docs.spring.io/spring-framework/reference/) |
| Spring Boot 4.1.1 | `demo` | [Spring Boot reference](https://docs.spring.io/spring-boot/reference/) |
| Apache Maven | All modules | [Maven guides](https://maven.apache.org/guides/) |
| MySQL Connector/J 9.5.0 | `MavenDemo` (dependency declared, not yet used in code) | [MySQL docs](https://dev.mysql.com/doc/) |
| Git & GitHub | Version control | [Git docs](https://git-scm.com/doc) |
| IntelliJ IDEA | Development environment | — |

## 📚 Projects and Learning Modules

| Module | Focus | Status |
|---|---|---|
| [CoreDemo](CoreDemo) | Interfaces, abstraction, polymorphism | Practice project |
| [MavenDemo](MavenDemo) | Maven structure and dependencies | Practice project |
| [SpringCoreDemo](SpringCoreDemo) | IoC, beans, dependency injection | 🔄 In progress |
| [demo](demo) | Spring Boot and REST endpoints | 🔄 In progress |

### [CoreDemo](CoreDemo): Notification Services

An order-processing example built on a `NotificationService` interface with Email, SMS, and pop-up implementations. `OrderService` currently creates an `EmailService` directly. This is the "before dependency injection" baseline that the Spring modules improve on.

### [MavenDemo](MavenDemo): Maven Fundamentals

A small project for learning Maven project layout, `pom.xml`, and dependency declaration. It declares the MySQL Connector/J dependency; database code is still to come.

### [SpringCoreDemo](SpringCoreDemo): Spring Core Fundamentals

A plain Spring Core console app (not Spring Boot) that starts an `AnnotationConfigApplicationContext`. It uses `@Configuration` with `@Bean` methods, a `PaymentService` interface with card and UPI implementations, `@Qualifier` selection, and constructor injection in `OrderService`.

Detailed lecture notes: [SpringCoreDemo Documentation](SpringCoreDemo/README.md).

### [demo](demo): REST Endpoints with Spring Boot

A Spring Boot web app using Spring MVC, configured to run on port `9090`.

| Method | Endpoint | Response |
|---|---|---|
| GET | `/hello` | Hello World heading |
| GET | `/bye` | Bye heading |

## 💡 Technical Concepts in the Code

| Concept | What it is | Why it helps | Where to see it |
|---|---|---|---|
| Interface-driven design | Code against a contract, not a concrete class | Implementations can be swapped | [`NotificationService`](CoreDemo/src/main/java/in/coderarmy/notification/NotificationService.java), [`PaymentService`](SpringCoreDemo/src/main/java/in/coderarmy/payment/PaymentService.java) |
| Separation of concerns | Each class has one job | Easier to read and change | [`CoreDemo/notification`](CoreDemo/src/main/java/in/coderarmy/notification) |
| Constructor injection | Dependencies passed in through the constructor | Visible, testable dependencies | [`OrderService`](SpringCoreDemo/src/main/java/in/coderarmy/OrderService.java) · [Spring docs](https://docs.spring.io/spring-framework/reference/) |
| Explicit bean configuration | `@Bean` methods register objects with Spring | Full control over object creation | [`AppConfig`](SpringCoreDemo/src/main/java/in/coderarmy/AppConfig.java) · [Spring docs](https://docs.spring.io/spring-framework/reference/) |
| `@Qualifier` | Picks one bean when several share a type | Resolves ambiguous injection | [`AppConfig`](SpringCoreDemo/src/main/java/in/coderarmy/AppConfig.java) |
| Maven dependency management | Declare libraries in `pom.xml` | Reproducible builds | [`MavenDemo/pom.xml`](MavenDemo/pom.xml), [`demo/pom.xml`](demo/pom.xml) |
| REST endpoints with Spring MVC | `@RestController` + `@GetMapping` | Expose HTTP endpoints | [`HelloController`](demo/src/main/java/com/example/demo/HelloController.java) · [Spring Boot docs](https://docs.spring.io/spring-boot/reference/) |
| Externalised configuration | Settings in `application.properties` | Change behaviour without code | [`application.properties`](demo/src/main/resources/application.properties) |

`@ComponentScan`, `@Primary`, and `ApplicationContext` vs `BeanFactory` are explained in the [SpringCoreDemo notes](SpringCoreDemo/README.md), but they aren't active in the current code, so they aren't listed above.

## 🗂️ Repository Structure

```
SpringBoot-BootCamp/
├── CoreDemo/
│   ├── pom.xml
│   └── src/main/java/in/coderarmy/
│       └── notification/
├── MavenDemo/
│   ├── pom.xml
│   └── src/main/java/org/example/
│       └── controller/
├── SpringCoreDemo/
│   ├── README.md
│   ├── pom.xml
│   └── src/main/java/in/coderarmy/
│       └── payment/
├── demo/
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/example/demo/
│       ├── main/resources/
│       └── test/java/
└── README.md
```

Each top-level folder is an independent Maven project. `demo` also includes the Maven Wrapper.

## 📈 Learning Progress

🟢 Practised in code · 🔄 Currently learning · 📅 Planned

| Topic | Status | Evidence |
|---|---|---|
| Java Fundamentals | 🟢 | [CoreDemo](CoreDemo) |
| Object-Oriented Programming | 🟢 | Interfaces and polymorphism in [CoreDemo](CoreDemo) |
| Maven | 🔄 | [MavenDemo](MavenDemo), [demo](demo) |
| Spring Core | 🔄 | [SpringCoreDemo](SpringCoreDemo) |
| Spring Boot | 🔄 | [demo](demo) |
| REST APIs | 🔄 | Two GET endpoints in [demo](demo) |
| Database Integration | 📅 | Connector declared in [MavenDemo](MavenDemo) |
| Backend Development | 🔄 | Ongoing |

## 🔭 Future Learning Goals

These are goals, not existing implementations.

- [ ] Spring Boot REST API development
- [ ] JDBC and database integration
- [ ] Spring Data JPA
- [ ] Bean Validation
- [ ] Global exception handling
- [ ] Unit and integration testing
- [ ] Security fundamentals

## 👨‍💻 Author

**Vamsi Krishna Yadav** · GitHub: [@VamsiKrishna-9443](https://github.com/VamsiKrishna-9443)

<p align="center"><em>Learn. Build. Test. Improve.</em></p>

<p align="center"><sub>Animated banner by <a href="https://readme-typing-svg.demolab.com/">readme-typing-svg</a> · Badges by <a href="https://shields.io/">Shields.io</a></sub></p>
