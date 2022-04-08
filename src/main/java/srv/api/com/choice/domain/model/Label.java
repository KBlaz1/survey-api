package srv.api.com.choice.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The model class for the Choice's label
 */
@Embeddable
public class Label {

    /**
     * Choice's label text
     */
    @NotNull
    @Column(name = "label")
    private String text;

    public Label() {};

    private Label(String text) {
        this.text = text;
    }

    public static Label create(String text) {
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
