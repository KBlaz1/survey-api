package srv.api.com.answeroption.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerOptionText {

    private String text;

    public AnswerOptionText() {};

    private AnswerOptionText(String text) {
        this.text = text;
    }

    public static AnswerOptionText create(String text) {
        return new AnswerOptionText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
