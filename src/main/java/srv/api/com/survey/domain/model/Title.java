package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class Title {

    @NotNull
    private String titleText;

    public Title() {}

    private Title(String titleText) {
        this.titleText = titleText;
    }

    public static Title create(String titleText) {
        return new Title(titleText);
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }
}
