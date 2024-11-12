import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Question class to represent each quiz question
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

// Quiz class to manage a collection of questions
class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start(String candidateName) {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();

            // Print options in one line
            for (int i = 0; i < options.length; i++) {
                System.out.print((i + 1) + ": " + options[i]);
                if (i < options.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(); // Move to the next line after printing all options

            int userAnswer = getUserInput(scanner, options.length);

            if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + options[question.getCorrectAnswerIndex()]);
            }
            System.out.println();
        }

        System.out.println("Quiz completed! " + candidateName + ", your score is: " + score + "/" + questions.size());
        System.out.println("Thank You! ");
        scanner.close();
    }


    // Input validation for user response
    private int getUserInput(Scanner scanner, int numOfOptions) {
        int userAnswer = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your answer (1-" + numOfOptions + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
                if (userAnswer >= 1 && userAnswer <= numOfOptions) {
                    validInput = true;
                } else {
                    System.out.println("Invalid option. Please select a number between 1 and " + numOfOptions);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return userAnswer;
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  candidate's name
        System.out.print("Enter your name: ");
        String candidateName = scanner.nextLine();
        System.out.print("\n");

        Quiz quiz = new Quiz();

        // List of questions
        quiz.addQuestion(new Question(
                "Q1. Which language is known as the backbone of web development?",
                new String[]{"JavaScript", "Python", "Ruby", "C++"},
                0
        ));
        quiz.addQuestion(new Question(
                "Q2. Which keyword is used to define a class in Java?",
                new String[]{"class", "Class", "define", "struct"},
                0
        ));
        quiz.addQuestion(new Question(
                "Q3. In Python, what data type is the output of `type(5.0)`?",
                new String[]{"int", "str", "float", "bool"},
                2
        ));
        quiz.addQuestion(new Question(
                "Q.4 Which HTML tag is used to include JavaScript code?",
                new String[]{"<script>", "<javascript>", "<js>", "<code>"},
                0
        ));
        quiz.addQuestion(new Question(
                "Q5. What does 'CSS' stand for?",
                new String[]{"Cascading Style Sheets", "Creative Style Sheets", "Computer Style Sheets", "Colorful Style Sheets"},
                0
        ));
        quiz.addQuestion(new Question(
                "Q6. Which of the following is NOT a relational database management system?",
                new String[]{"MySQL", "Oracle", "MongoDB", "PostgreSQL"},
                2
        ));
        quiz.addQuestion(new Question(
                "Q7. Which sorting algorithm has the best average time complexity?",
                new String[]{"Bubble Sort", "Selection Sort", "Merge Sort", "Insertion Sort"},
                2
        ));
        quiz.addQuestion(new Question(
                "Q8. Which keyword is used to create an object in JavaScript?",
                new String[]{"new", "create", "Object", "instance"},
                0
        ));
        
        quiz.addQuestion(new Question(
                "Q9. What is the time complexity of searching an element in a binary search tree (average case)?",
                new String[]{"O(log n)", "O(n)", "O(n log n)", "O(n^2)"},
                0
        ));
        quiz.addQuestion(new Question(
                "Q10. Which of the following is a NoSQL database?",
                new String[]{"SQL Server", "PostgreSQL", "MongoDB", "SQLite"},
                2
        ));


        // Start the quiz and pass the candidate's name
        quiz.start(candidateName);

        scanner.close();
    }
}
