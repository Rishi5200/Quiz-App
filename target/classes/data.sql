CREATE TABLE IF NOT EXISTS question (
    id INT PRIMARY KEY,
    questionText VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    correctAnswer VARCHAR(255)
);
CREATE TABLE quiz_session (
    id INT PRIMARY KEY,
    questionsAnswered INT,
    correctAnswers INT,
    incorrectAnswers INT
);

INSERT INTO question (id, questionText, option1, option2, option3, option4, correctAnswer)
VALUES (1, 'What is the capital of France?', 'Paris', 'London', 'Berlin', 'Madrid', 'Paris');

INSERT INTO quiz_session (id, questionsAnswered, correctAnswers, incorrectAnswers)
VALUES (1, 0, 0, 0);
