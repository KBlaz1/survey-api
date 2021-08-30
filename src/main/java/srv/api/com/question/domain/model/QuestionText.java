package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionText {

    @NotNull
    private String questionText;

    public QuestionText() {}

    private QuestionText(String questionText) {
        this.questionText = questionText;
    }

    public static QuestionText create(String questionText) {
        return new QuestionText(questionText);
    }

    public String getText() {
        return questionText;
    }

    public void setText(String questionText) {
        this.questionText = questionText;
    }
}
