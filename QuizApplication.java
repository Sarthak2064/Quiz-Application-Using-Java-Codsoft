import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctOption;

    public QuizQuestion(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int chosenOption) {
        return chosenOption == correctOption;
    }
}

public class QuizApplication {
    private static final int QUESTION_COUNT = 3; // Number of questions in the quiz
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds

    private QuizQuestion[] questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private Scanner scanner;

    public QuizApplication() {
        // Initialize quiz questions with options and correct answers
        questions = new QuizQuestion[QUESTION_COUNT];
        questions[0] = new QuizQuestion("What is the capital of France?",
                new String[]{"A. London", "B. Paris", "C. Rome", "D. Madrid"}, 1);
        questions[1] = new QuizQuestion("Which planet is known as the Red Planet?",
                new String[]{"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"}, 2);
        questions[2] = new QuizQuestion("Who painted the Mona Lisa?",
                new String[]{"A. Vincent van Gogh", "B. Leonardo da Vinci", "C. Pablo Picasso", "D. Michelangelo"}, 1);

        currentQuestionIndex = 0;
        score = 0;
        timer = new Timer();
        scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + TIME_LIMIT + " seconds to answer each question.");

        askQuestion();
    }

    private void askQuestion() {
        if (currentQuestionIndex < QUESTION_COUNT) {
            QuizQuestion currentQuestion = questions[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    nextQuestion();
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000);

            System.out.print("\nEnter your answer (choose 1, 2, 3, or 4): ");
            int chosenOption = scanner.nextInt();
            timer.cancel(); // Cancel timer as the user has answered

            if (currentQuestion.isCorrect(chosenOption)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Incorrect answer!");
            }

            currentQuestionIndex++;
            askQuestion();
        } else {
            displayResult();
        }
    }

    private void nextQuestion() {
        timer.cancel(); // Cancel timer as the time is up
        currentQuestionIndex++;
        askQuestion();
    }

    private void displayResult() {
        System.out.println("\nQuiz ended!");
        System.out.println("Your final score: " + score + " out of " + QUESTION_COUNT);
        int incorrect = QUESTION_COUNT - score;
        System.out.println("Correct answers: " + score);
        System.out.println("Incorrect answers: " + incorrect);
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }
}
