package srv.api.com.answeroption.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerOptionText {

    private String answerOptionText;

    public AnswerOptionText() {};

    private AnswerOptionText(String answerOptionText) {
        this.answerOptionText = answerOptionText;
    }

    public static AnswerOptionText create(String answerOptionText) {
        return new AnswerOptionText(answerOptionText);
    }

    public String getText() {
        return answerOptionText;
    }

    public void setText(String text) {
        this.answerOptionText = text;
    }
}
