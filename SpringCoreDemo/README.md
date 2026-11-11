
<!-- GitHub README: animated SVG heading (GitHub renders the image; no custom JS is required) --> <p align="center"> <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=23&pause=1000&color=6DB33F&center=true&vCenter=true&width=850&lines=Learn+Spring+Core+Step+by+Step;Understand+IoC+%26+Dependency+Injection;Explore+Beans+%26+Spring+Annotations" alt="Animated Spring Core learning heading" /> </p><h1 align="center">🌱 Spring Core Demo</h1><p align="center"> <strong>Learn how Spring creates objects, manages beans, and injects dependencies.</strong><br /> A hands-on companion to the Spring Core lecture on IoC, DI, beans, annotations, and ApplicationContext. </p><p align="center"> <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white" alt="Java 21" /> <img src="https://img.shields.io/badge/Spring_Framework-7.0.7-6DB33F?logo=spring&logoColor=white" alt="Spring Framework 7.0.7" /> <img src="https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white" alt="Maven" /> <img src="https://img.shields.io/badge/Focus-Spring_Core-blue" alt="Spring Core" /> <img src="https://img.shields.io/badge/Project-Learning-lightgrey" alt="Learning project" /> </p><p align="center"> <a href="#-what-you-will-learn">Learning path</a> · <a href="#-project-structure">Project structure</a> · <a href="#-run-the-project">Run project</a> · <a href="#-lecture-concepts-explained">Concepts</a> · <a href="#-practice-exercises">Exercises</a> </p>
📚 About this folder
This folder contains hands-on examples for the lecture Spring IOC Container | Beans, @Component, @Autowired & @Bean | Spring Boot Full Course #5.

The goal is to understand Spring fundamentals before moving deeper into Spring Boot. This is a plain Spring Core console project, not a Spring Boot web application.

The code uses a small order-and-payment example to demonstrate:

How Spring discovers and registers application components.
How the IoC container manages objects (Spring beans).
How constructor injection supplies a dependency to a service.
How @Qualifier selects one implementation when multiple beans share an interface.
The notes below also explain the other concepts covered in the lecture, including @Bean, @Primary, Bean Definitions, Java Reflection, and ApplicationContext.

🎯 What you will learn
Concept	Simple meaning
Dependency Injection (DI)	Give a class the objects it needs instead of creating them inside that class.
Inversion of Control (IoC)	Let Spring take control of creating and connecting managed objects.
Spring Bean	An object registered with and managed by the Spring container.
@Component	Mark a concrete class for discovery through component scanning.
@Configuration	Mark a class that provides Spring configuration.
@ComponentScan	Tell Spring which package to scan for components.
@Autowired	Ask Spring to resolve and inject a dependency.
Constructor Injection	Supply required dependencies through a constructor.
@Qualifier	Select a particular bean when several candidates match.
@Primary	Mark the preferred candidate when no more specific choice is given.
@Bean	Register the object returned by a configuration method.
Bean Definition	Metadata describing how Spring should create and configure a bean.
ApplicationContext	The commonly used, feature-rich Spring IoC container interface.
BeanFactory	The basic IoC container interface extended by ApplicationContext.
🧭 Learning path
🗂️ Project structure
SpringCoreDemo/
├── pom.xml
└── src/
└── main/
└── java/
└── in/
└── coderarmy/
├── AppConfig.java
├── Main.java
├── OrderService.java
└── payment/
├── PaymentService.java
├── CardPayment.java
└── UpiPayment.java
What each file does
File	Responsibility
pom.xml	Defines the Maven project, Java 21 compiler settings, and Spring Context dependency.
AppConfig.java	Enables component scanning for the in.coderarmy package.
Main.java	Starts the annotation-based Spring context and retrieves OrderService.
OrderService.java	Places an order and receives a PaymentService through constructor injection.
PaymentService.java	Defines the payment contract through the pay() method.
CardPayment.java	Implements the payment contract for card payments.
UpiPayment.java	Implements the payment contract for UPI payments.
Source files
AppConfig.java
Main.java
OrderService.java
PaymentService.java
CardPayment.java
UpiPayment.java
pom.xml
⚙️ Technology used
Technology	Project configuration
Java	21
Spring Framework	7.0.7
Build tool	Maven
Main dependency	org.springframework:spring-context
Application type	Plain Java / Spring Core console application
IDE	IntelliJ IDEA
The Maven dependency used by this project is:

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.7</version>
</dependency>
The spring-context module provides ApplicationContext and the core facilities used here. This is not a Spring Boot project, so spring-boot:run is not the command to use.

▶️ Run the project
1. Requirements
   JDK 21 installed and configured.
   IntelliJ IDEA or another Java IDE.
   Maven installed, or Maven support enabled in the IDE.
   Check your environment:

java -version
mvn -version
2. Open the project
   Open the SpringCoreDemo folder in IntelliJ IDEA and allow Maven to load the dependencies from pom.xml.

3. Compile
   Run this command from the folder that contains pom.xml:

mvn clean compile
4. Run
   Open src/main/java/in/coderarmy/Main.java and run its main() method from IntelliJ IDEA.

The current OrderService constructor uses @Qualifier("cp"), so Spring injects the card payment implementation. Expected output:

Paying via Card
Order placed
🧠 Lecture concepts explained
The sections follow the lecture's order. Each concept includes its definition, purpose, and a small Java example.

1. Dependency Injection (DI)
   Definition: Dependency Injection is a technique in which an object receives the other objects it depends on from an external source instead of creating those objects itself.

In simple terms: If an order needs a payment service, give the payment service to the order service. Do not make the order service create its own payment service.

Without DI
class OrderService {
private PaymentService paymentService = new CardPayment();
}
Here, OrderService chooses and creates a concrete implementation itself. That makes it directly dependent on CardPayment.

With constructor DI
class OrderService {
private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
Now an external caller or the Spring container supplies the dependency.

Why use DI?

Reduces direct coupling between classes.
Makes implementations easier to replace.
Makes unit testing easier because a fake or mock can be passed in.
Separates object creation from business logic.
Project connection: OrderService needs a PaymentService to place an order.

2. Inversion of Control (IoC)
   Definition: Inversion of Control is a design principle in which responsibility for creating objects and connecting their dependencies is moved from application code to a framework or container.

In simple terms: Instead of your code controlling every object, Spring controls the objects registered with its container.

Without Spring, main() might create a payment object and pass it to an order object. With Spring, you describe the components and configuration, and the container creates and connects managed objects.

DI and IoC are related, but not identical:

IoC is the broader principle of handing control to the framework.
DI is a way to supply an object's dependencies from outside.
The Spring IoC container manages Spring beans and their dependencies.
3. Spring IoC Container
   Definition: The Spring IoC container creates, configures, wires, and manages Spring beans.

In simple terms: Think of it as the part of Spring that keeps track of the application objects it manages.

The container reads configuration, discovers components, creates bean definitions, instantiates beans, and resolves dependencies. This project starts it with AnnotationConfigApplicationContext.

4. Spring Context dependency
   Definition: spring-context is a Spring Framework module that provides ApplicationContext and supporting application-context facilities.

Why use it? It lets a plain Java application use Spring's IoC container and annotation-based configuration without creating a Spring Boot web application.

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.7</version>
</dependency>
After changing pom.xml, reload Maven in your IDE.

5. Java Reflection API
   Definition: Reflection is a Java feature that lets a program inspect class information at runtime, such as fields, methods, constructors, and annotations.

In simple terms: Java code can examine a class's structure while the program is running.

import java.lang.reflect.Field;

class Student {
private int id;
private String name;
}

public class ReflectionExample {
public static void main(String[] args) {
Class<?> studentClass = Student.class;
System.out.println(studentClass.getName());

        for (Field field : studentClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
Possible output:

Student
id
name
Connection to Spring: Reflection is one of the mechanisms Spring can use to inspect classes, constructors, and annotations while creating and wiring the application context.

6. Spring Bean
   Definition: A Spring Bean is an object registered with and managed by the Spring IoC container.

A normal Java object is not automatically a Spring bean:

Student student = new Student();
That object was created directly by application code. It becomes a Spring-managed bean only when it is registered with the container, for example through component scanning or a @Bean method.

Remember: Every Spring bean is an object, but not every Java object is a Spring bean.

Why use beans? Spring can manage object creation, dependency wiring, and lifecycle callbacks for registered beans.

7. @Component
   Definition: @Component marks a class as a candidate for automatic discovery during component scanning.

Example:

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService {
@Override
public void pay() {
System.out.println("Paying via Card");
}
}
When the class is inside a package being scanned, Spring discovers it and registers a bean. By default, the bean name is derived from the class name. CardPayment normally becomes cardPayment.

You can set an explicit component name:

@Component("card")
public class CardPayment implements PaymentService {
// implementation
}
Why use it? It is a convenient way to register application classes without writing a separate factory method for each one.

Good practice: Put @Component on concrete classes that Spring should instantiate. An interface defines a contract; annotate its implementation classes when those implementations should become beans.

8. @Configuration
   Definition: @Configuration marks a class as a source of Spring bean configuration.

Example from this project:

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.coderarmy")
public class AppConfig {
}
A configuration class can also contain methods annotated with @Bean.

9. @ComponentScan
   Definition: @ComponentScan tells Spring which package to search for components.

@Configuration
@ComponentScan("in.coderarmy")
public class AppConfig {
}
Spring scans in.coderarmy and its sub-packages for eligible components.

Why use it? You do not need to register every component manually. Spring discovers annotated classes within the scan scope.

10. AnnotationConfigApplicationContext
    Definition: AnnotationConfigApplicationContext is an ApplicationContext implementation that starts Spring using Java-based configuration and annotations.

Example matching this project:

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
public static void main(String[] args) {
ApplicationContext context =
new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();
    }
}
What happens?

The context constructor starts the Spring container using AppConfig.
Spring processes the configuration and scans the configured package.
Spring creates and wires the beans.
getBean(OrderService.class) retrieves the managed order service.
placeOrder() runs the business operation.
For a longer-running example, you can close the context when finished. AnnotationConfigApplicationContext implements AutoCloseable, so a try-with-resources block is also possible.

11. @Autowired
    Definition: @Autowired asks Spring to resolve a dependency and inject a matching bean.

@Component
public class OrderService {
private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
When Spring creates OrderService, it looks for a bean matching PaymentService. If multiple beans match, add selection information such as @Qualifier or @Primary.

12. Three common types of Dependency Injection
    A. Constructor Injection
    The dependency is passed through the constructor.

@Component
public class OrderService {
private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
Use it for required dependencies. It makes dependencies visible and supports final fields. If a class has only one constructor, Spring does not require @Autowired on that constructor.

B. Setter Injection
The dependency is passed through a setter method.

@Component
public class OrderService {
private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
It can be useful for optional dependencies or setter-based configuration.

C. Field Injection
Spring injects the dependency directly into a field.

@Component
public class OrderService {
@Autowired
private PaymentService paymentService;
}
It is concise, but it hides dependencies and makes isolated unit testing harder. Constructor injection is generally preferred for required dependencies.

Why constructor injection is recommended
Required dependencies are supplied during construction.
Fields can be declared final.
Dependencies are visible in the constructor signature.
Tests can pass a mock or fake implementation directly.
13. Bean Definition
    Definition: A Bean Definition is metadata that describes how Spring should create and configure a bean. It is not the bean instance itself.

Think of it as a recipe: it describes which class to create and the configuration information Spring needs.

A simplified startup sequence:

Understanding this sequence helps when diagnosing bean-not-found and dependency-resolution errors.

14. Loose coupling with interfaces
    Definition: Loose coupling means a class depends on an abstraction rather than being hard-wired to one specific implementation.

The project defines a payment contract:

public interface PaymentService {
void pay();
}
Different classes implement that contract:

@Component
@Qualifier("cp")
public class CardPayment implements PaymentService {
@Override
public void pay() {
System.out.println("Paying via Card");
}
}
@Component
@Qualifier("up")
public class UpiPayment implements PaymentService {
@Override
public void pay() {
System.out.println("Paying by UPI");
}
}
OrderService depends on PaymentService, not directly on CardPayment or UpiPayment.

Why use interfaces? You can add or replace implementations while keeping the dependent service focused on the contract.

15. @Qualifier and @Primary
    The multiple-bean problem
    Both CardPayment and UpiPayment implement PaymentService. If a constructor asks only for PaymentService, Spring finds more than one candidate and cannot infer which one is intended. This commonly results in NoUniqueBeanDefinitionException.

A. @Qualifier
Definition: @Qualifier narrows dependency selection to a bean with a particular qualifier.

In this project, CardPayment declares qualifier cp, and UpiPayment declares qualifier up.

The current OrderService constructor selects card payment:

public OrderService(@Qualifier("cp") PaymentService paymentService) {
this.paymentService = paymentService;
}
To select UPI instead, use @Qualifier("up").

B. @Primary
Definition: @Primary marks a bean as the preferred candidate when Spring resolves a dependency and no more specific qualifier is supplied.

@Component
@Primary
public class CardPayment implements PaymentService {
// implementation
}
@Primary	@Qualifier
Marks a preferred candidate.	Selects a particular candidate at the injection point.
Useful for a default implementation.	Useful when a specific implementation is required.
Can be used on a component or bean definition.	Commonly used at the injection point to narrow the choice.
If an injection point includes a matching qualifier, that selection is more specific than the default preference.

16. When @Component is not enough
    The lecture discusses two useful cases.

Case 1: Constructor values must be provided
public class User {
private final String name;
private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
Component scanning alone does not tell Spring which name and age values the application wants. You need to configure how the object is created.

Case 2: Third-party classes
A class from a library may be provided in a JAR. You usually cannot edit that library class to add @Component. In this case, explicitly define a bean in your configuration with @Bean.

17. @Bean
    Definition: @Bean marks a method in a Spring configuration class. The object returned by the method is registered with the IoC container.

Simple comparison:

@Component: annotate a class and let component scanning discover it.
@Bean: write a method that constructs and returns the object.
Example with a class that needs constructor arguments:

public class User {
private final String name;
private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println(name + " " + age);
    }
}
Configuration:

@Configuration
public class AppConfig {
@Bean
public User createUser() {
return new User("Aditya", 28);
}
}
Spring registers the returned User object as a bean. By default, the method name createUser is the bean name.

Retrieve it:

var context = new AnnotationConfigApplicationContext(AppConfig.class);
User user = context.getBean(User.class);
user.display();
context.close();
Output:

Aditya 28
Why use @Bean?

To supply constructor values explicitly.
To register objects from third-party libraries.
To control object creation with Java code.
To register an object without annotating its class.
18. Injecting dependencies into @Bean methods
    Spring can resolve a bean parameter for an @Bean method.

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {
        return new CardPayment();
    }

    @Bean
    public OrderService orderService(PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
When Spring invokes orderService(...), it supplies the registered PaymentService bean as the method argument.

If several beans implement PaymentService, use a qualifier on the parameter:

@Bean
public OrderService orderService(
@Qualifier("up") PaymentService paymentService) {
return new OrderService(paymentService);
}
The qualifier must match the relevant qualifier metadata or bean name.

19. Why keep configuration separate from Main?
    Keep responsibilities clear:

Main starts the application context and runs the application.
AppConfig describes how Spring discovers or creates beans.
Service classes contain application behaviour.
This separation makes an application easier to read and extend.

20. ApplicationContext vs BeanFactory
    Both are Spring IoC container interfaces.

BeanFactory	ApplicationContext
Basic IoC container interface.	Extends BeanFactory.
Provides fundamental bean management.	Adds application-level facilities.
More minimal container API.	Supports facilities such as events, message resolution, and resource loading.
Which is commonly used? ApplicationContext is the usual choice in modern Spring applications.

ApplicationContext context =
new AnnotationConfigApplicationContext(AppConfig.class);
The variable uses the ApplicationContext interface, while the object is an AnnotationConfigApplicationContext.

🔍 How the current project works
The current implementation follows this dependency flow:

Execution explained
Main starts the Spring context using AppConfig.
AppConfig tells Spring to scan in.coderarmy.
Spring discovers OrderService, CardPayment, and UpiPayment.
Spring sees that OrderService needs a PaymentService.
@Qualifier("cp") selects the card payment bean.
placeOrder() calls paymentService.pay().
The selected implementation prints the payment message, followed by Order placed.
Current implementation vs lecture topics
Topic	Present in current project?
@Configuration	Yes
@ComponentScan	Yes
@Component	Yes, on concrete components
Constructor injection	Yes
@Qualifier	Yes — OrderService selects cp
Interface-based loose coupling	Yes — PaymentService
@Bean example	Explained in these notes; not currently defined in AppConfig
@Primary example	Explained in these notes; not currently used to select the payment bean
BeanFactory comparison	Explained in these notes
Important: Avoid registering the same implementation twice unintentionally. If CardPayment is component-scanned and you also create another CardPayment object through an @Bean method, the container can have two beans of the same type. Injection may then be ambiguous unless bean selection is configured.

🧪 Practice exercises
Try these in order. Write the code yourself, run it, and observe how the container behaves.

<details> <summary><strong>Exercise 1 — Manual Dependency Injection</strong></summary>
Create a PaymentService class with a pay() method.
Create an OrderService class.
Pass PaymentService through the OrderService constructor.
Create both objects manually in Main.
Call placeOrder().
Goal: Understand DI without Spring.

</details><details> <summary><strong>Exercise 2 — Register beans with @Component</strong></summary>
Add @Component to OrderService.
Add @Component to a concrete payment implementation.
Add @Configuration and @ComponentScan to AppConfig.
Start AnnotationConfigApplicationContext.
Retrieve OrderService using getBean().
Goal: Let Spring discover and create the objects.

</details><details> <summary><strong>Exercise 3 — Compare injection types</strong></summary>
Implement constructor, setter, and field injection in separate attempts. For each approach, ask:

Where is the dependency declared?
When is the dependency supplied?
Can the dependency be final?
How easy is it to create the class in a unit test?
Goal: Understand why constructor injection is commonly preferred for required dependencies.

</details><details> <summary><strong>Exercise 4 — Resolve multiple payment beans</strong></summary>
Create CardPayment and UpiPayment.
Make both implement PaymentService.
Inject PaymentService without a qualifier.
Observe the ambiguity error.
Resolve it using @Primary.
Try again using @Qualifier.
Goal: Understand how Spring chooses between multiple matching beans.

</details><details> <summary><strong>Exercise 5 — Create a bean using @Bean</strong></summary>
Create a User class with name and age.
Give it a constructor that accepts both values.
Register it using an @Bean method in AppConfig.
Retrieve it using context.getBean(User.class).
Display the user information.
Goal: Understand explicit bean creation and registration.

</details><details> <summary><strong>Exercise 6 — Inject a bean into another @Bean method</strong></summary>
Define a PaymentService bean using @Bean.
Define an OrderService bean using another @Bean method.
Accept PaymentService as a parameter to the OrderService bean method.
Retrieve the order bean and call placeOrder().
Goal: Understand dependency injection through configuration methods.

</details>
🛠️ Common errors and what they mean
Error / symptom	What to check
NoSuchBeanDefinitionException	Is the class registered as a bean? Is its package included in component scanning?
NoUniqueBeanDefinitionException	Are multiple beans of the same type available? Use @Qualifier or an appropriate @Primary.
Dependency is null	Is the object Spring-managed, and is the dependency configured for injection?
Component is not discovered	Check the package in @ComponentScan and ensure the concrete class has a component annotation.
Constructor injection fails	Check whether Spring can resolve every constructor parameter.
Example: understanding a multiple-bean error
If Spring reports that it found cardPayment and upiPayment for one PaymentService dependency, the interface is not the problem. Spring has more than one candidate.

Choose the intended implementation explicitly:

public OrderService(@Qualifier("cp") PaymentService paymentService) {
this.paymentService = paymentService;
}
📝 Quick revision sheet
If you see...	Think...
DI	Supply dependencies from outside the class.
IoC	Spring takes control of managed object creation and wiring.
Bean	An object managed by Spring.
@Component	Discover this class during component scanning.
@Configuration	This class contains Spring configuration.
@ComponentScan	Search this package for components.
@Autowired	Resolve and inject a dependency.
Constructor Injection	Pass a required dependency during object creation.
@Qualifier	Pick this particular bean.
@Primary	Prefer this bean by default.
@Bean	Register the object returned by this method.
Bean Definition	Metadata describing how to create/configure a bean.
ApplicationContext	Feature-rich Spring IoC container interface.
BeanFactory	Basic IoC container interface.
🎤 Interview questions to practise
What is Dependency Injection? Explain with a Java example.
What is Inversion of Control? How is it related to DI?
What is a Spring Bean?
What is the difference between a normal Java object and a Spring bean?
What does @Component do?
What are @Configuration and @ComponentScan used for?
What is @Autowired?
What are the three common types of dependency injection?
Why is constructor injection preferred?
What is a Bean Definition?
Why should a service depend on an interface?
What happens when Spring finds multiple beans of the same type?
What is the difference between @Primary and @Qualifier?
What is the difference between @Component and @Bean?
When should you use @Bean?
Can Spring inject a dependency into an @Bean method?
What is the difference between BeanFactory and ApplicationContext?
What role can Reflection play in Spring?
✅ Final takeaway
The central idea of this lecture is simple:

You define the objects and their relationships; Spring creates and manages the beans and injects their dependencies.

Understand this flow before moving deeper into Spring Boot. The same fundamentals are used when Spring manages controllers, services, repositories, and other components in a backend application.

<p align="center"> <strong>🌱 Learn the concept. Write the code. Run it. Debug it. Repeat.</strong><br /> <sub>Part of the <a href="../">SpringBoot-BootCamp</a> learning repository.</sub> </p>
⋮⋮⋮⋮