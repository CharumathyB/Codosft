package QuizApplicationJava;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }
        return null;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public void checkAnswer(int selectedOption) {
        Question currentQuestion = questions.get(currentQuestionIndex - 1);
        if (selectedOption == currentQuestion.getCorrectOptionIndex()) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }
}
