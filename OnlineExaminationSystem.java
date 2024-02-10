import java.util.*;

// Represents a single question with options and correct answer
class Question {
    private String question;          // Question text
    private List<String> options;     // List of options for the question
    private int correctOption;        // Index of the correct option (1-based)

    // Constructor to initialize question, options, and correct option
    public Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getter method for question text
    public String getQuestion() {
        return question;
    }

    // Getter method for options
    public List<String> getOptions() {
        return options;
    }

    // Getter method for correct option index
    public int getCorrectOption() {
        return correctOption;
    }
}

// Represents an exam with a list of questions
class Exam {
    private List<Question> questions;  // List of questions in the exam

    // Constructor to initialize exam with questions
    public Exam(List<Question> questions) {
        this.questions = questions;
    }

    // Method to conduct the exam
    public void conductExam() {
        Scanner scanner = new Scanner(System.in);   // Scanner object for user input
        int score = 0;  // Variable to track user's score

        // Loop through each question in the exam
        for (Question question : questions) {
            System.out.println(question.getQuestion());  // Display the question
            List<String> options = question.getOptions(); // Get options for the question
            
            // Display options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();  // Read user's choice

            // Check if user's choice is correct
            if (userChoice == question.getCorrectOption()) {
                System.out.println("Correct!");   // Display correct message
                score++;    // Increment score
            } else {
                System.out.println("Incorrect!"); // Display incorrect message
            }
        }

        // Display exam completion message and user's score
        System.out.println("Exam completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

// Main class containing the entry point of the program
public class OnlineExaminationSystem {
    public static void main(String[] args) {
        // Sample questions for the exam
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", Arrays.asList("Delhi", "Kolkata", "Bangalore", "Mumbai"), 1));
        questions.add(new Question("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 2));
        questions.add(new Question("Who is the president of the India?", Arrays.asList("Pratibha Patil", "Joe Biden", "Droupadi Murmu","George Bush"), 3));
        questions.add(new Question("Where is Tajmahal?", Arrays.asList("Kolkata", "Delhi", "UP", "Punjab"), 3));
        // Create an exam object with the list of questions
        Exam exam = new Exam(questions);

        // Conduct the exam
        exam.conductExam();
    }
}