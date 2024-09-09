package QuizApplicationJava;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class QuizApp {
    private static final long TIME_LIMIT_S = 15;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("What is the default value of a boolean variable in Java?", Arrays.asList("true", "false", "0", "null"), 1));
        quiz.addQuestion(new Question("Which keyword is used to define a class in Java?", Arrays.asList("class", "def", "struct", "object"), 0));
        quiz.addQuestion(new Question("What is the purpose of the static keyword in Java?", Arrays.asList("To create instance methods", "To indicate a method that can be called without an instance", "To create new threads", "To define a constant"), 1));
        quiz.addQuestion(new Question("Which of the following is a valid way to declare an array in Java?", Arrays.asList("int[] arr;", "array int arr;", "int arr[];", "Both int[] arr; and int arr[];"), 3));
        quiz.addQuestion(new Question("What is encapsulation in Java?", Arrays.asList("A way to protect data by restricting access", "A method of organizing code", "A type of data structure", "None of the above"), 0));

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quiz.getTotalQuestions(); i++) {
            Question currentQuestion = quiz.getNextQuestion();
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            AtomicBoolean answered = new AtomicBoolean(false);
            int[] selectedOption = new int[1];

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                if (!answered.get()) {
                    System.out.println("Time's up! The correct answer was option " + (currentQuestion.getCorrectOptionIndex() + 1));
                    answered.set(true); 
                }
            }, TIME_LIMIT_S, TimeUnit.SECONDS);

            System.out.println("You have " + TIME_LIMIT_S + " seconds to select an option.");

            while (!answered.get()) {
                if (scanner.hasNextInt()) {
                    selectedOption[0] = scanner.nextInt() - 1;
                    if (selectedOption[0] >= 0 && selectedOption[0] < options.size()) {
                        answered.set(true);
                        break;
                    } else {
                        System.out.println("Invalid option. Please select again.");
                    }
                } else {
                    scanner.next();                 }
            }

            if (selectedOption[0] >= 0 && selectedOption[0] < options.size()) {
                quiz.checkAnswer(selectedOption[0]);
            }

            scheduler.shutdown(); 
        }

        System.out.println("Quiz finished! Your score is " + quiz.getScore() + "/" + quiz.getTotalQuestions());
        scanner.close();
    }
}
