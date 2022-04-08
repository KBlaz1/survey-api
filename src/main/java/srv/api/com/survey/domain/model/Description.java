package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The model class for the Survey's description
 */
@Embeddable
public class Description {

    /**
     * Survey's description text
     */
    @NotNull
    @Column(name = "description")
    private String text;

    public Description() {}

    private Description(String text) {
        this.text = text;
    }

    public static Description create(String text) {
        return new Description(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Description{" +
                "text='" + text + '\'' +
                '}';
    }
}
