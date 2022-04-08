package srv.api.com.answer.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Label {

    @Column(name = "label")
    private String text;

    private Label(String text) {
        this.text = text;
    }

    public static Label Create(String text) {
        return new Label(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Label{" +
                "text='" + text + '\'' +
                '}';
    }
}
