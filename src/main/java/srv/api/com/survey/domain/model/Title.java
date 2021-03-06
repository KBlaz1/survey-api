package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The model class for the Survey's title
 */
@Embeddable
public class Title {

    /**
     * Survey's title text
     */
    @NotNull
    @Column(name = "title")
    private String text;

    public Title() {}

    private Title(String text) {
        this.text = text;
    }

    public static Title create(String text) {
        return new Title(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Title{" +
                "text='" + text + '\'' +
                '}';
    }
}
