# Quiz App

This is a simple quiz application built with Spring Boot. It provides a REST API to manage quiz sessions, fetch random multiple-choice questions, submit answers, and retrieve quiz results. It uses an in-memory H2 database for simplicity and seeds a default user and a few questions at startup.

# Features
Start a new quiz session: Begin a fresh quiz attempt associated with a single user.
Get a random question: Fetch a random multiple-choice question that the user has not yet answered in the current session.
Submit an answer: Submit the user’s selected option for a given question and see if it’s correct.
View results: Retrieve summary details of the quiz session, including total questions answered, correct/incorrect counts, and individual answers.
Assumptions
Single User Scenario:
The application seeds one user with id=1 and username="testuser". All sessions are associated with this single user.

**Sample Data:**
Two sample questions are seeded at startup. You can add more by modifying the initData method in QuizAppApplication.java.

**In-Memory Database (H2):**
Data is not persisted after the application restarts. Each time the application is run, it recreates the schema and seeds the user and questions.

**One-Session Flow:**
While multiple sessions can be created, the example frontend usage focuses on one session at a time. There’s no authentication or user management implemented.

**No Question Repetition in a Session:**
Each question can only appear once per session. Once answered, that question will not appear again.

# Technologies Used

Java 17 (or higher)

Spring Boot 3.x

Spring Data JPA

H2 Database

Maven

Project Structure

bash

Copy code

quiz-app
 ├─ src
 │   ├─ main
 │   │   ├─ java
 │   │   │   └─ com.example.quizapp
 │   │   │       ├─ QuizAppApplication.java
 │   │   │       ├─ controller
 │   │   │       │   └─ QuizController.java
 │   │   │       ├─ model
 │   │   │       │   ├─ Question.java
 │   │   │       │   ├─ QuizSession.java
 │   │   │       │   ├─ User.java
 │   │   │       │   └─ UserAnswer.java
 │   │   │       ├─ repository
 │   │   │       │   ├─ QuestionRepository.java
 │   │   │       │   ├─ QuizSessionRepository.java
 │   │   │       │   ├─ UserAnswerRepository.java
 │   │   │       │   └─ UserRepository.java
 │   │   │       └─ service
 │   │   │           ├─ QuizService.java
 │   │   │           └─ SessionResult.java
 │   │   └─ resources
 │   │       ├─ application.properties
 │   │       └─ (any static/html files if needed)
 │   └─ test
 │       └─ (test classes)
 ├─ pom.xml
 └─ README.md
Configuration
src/main/resources/application.properties contains the configuration for H2 and JPA:

# Properties
Copy code
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
To view the H2 console:

**To Run the application**
Go to http://localhost:8080/h2-console
Use jdbc:h2:mem:testdb as the JDBC URL
Running the Application

**bash**

mvn spring-boot:run

The application will start on http://localhost:8080.

# Prerequisites:

Java 21 or higher installed

Maven installed

Build and Run:

From the project root directory:

**API Endpoints**
Start New Session:
POST /api/quiz/start
Returns a QuizSession object with id and startTime.

**Get Random Question:**

GET /api/quiz/question?sessionId={sessionId}

Returns a random Question that the user hasn’t answered yet during this session. If no new questions are available, a RuntimeException is thrown.

**Submit Answer:**

POST /api/quiz/submit?sessionId={sessionId}&questionId={questionId}&selectedOption={A/B/C/D}

Returns a UserAnswer object with a correct field indicating if the submitted answer was correct.

**Get Results:**

GET /api/quiz/result?sessionId={sessionId}

Returns a SessionResult containing totalAnswered, correctCount, incorrectCount, and details of each UserAnswer.

**Simple Frontend (Optional)**

A simple index.html file with JavaScript fetch calls can be used to interact with these endpoints. Place it in src/main/resources/static or run it via a separate local web server. Ensure CORS is configured if running from a different origin.
