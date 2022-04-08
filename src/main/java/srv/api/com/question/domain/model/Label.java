package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The model class for the Question's Label
 */
@Embeddable
public class Label {

    /**
     * Question's label text
     */
    @NotNull
    @Column(name = "label")
    private String text;

    public Label() {}

    private Label(String text) {
        this.text = text;
    }

    public static Label create(String questionText) {
        return new Label(questionText);
    }

    public String getText() {
        return text;
    }

    public void setText(String questionText) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Title{" +
                "text='" + text + '\'' +
                '}';
    }
}
