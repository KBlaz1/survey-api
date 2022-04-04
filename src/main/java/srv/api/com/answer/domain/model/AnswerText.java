package srv.api.com.answer.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerText {

    private String text;

    private AnswerText(String text) {
        this.text = text;
    }

    public static AnswerText Create(String text) {
        return new AnswerText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
