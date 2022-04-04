package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionText {

    @NotNull
    private String text;

    public QuestionText() {}

    private QuestionText(String text) {
        this.text = text;
    }

    public static QuestionText create(String questionText) {
        return new QuestionText(questionText);
    }

    public String getText() {
        return text;
    }

    public void setText(String questionText) {
        this.text = text;
    }
}
