package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class Description {

    @NotNull
    private String descriptionText;

    public Description() {}

    private Description(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public static Description create(String descriptionText) {
        return new Description(descriptionText);
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescription(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    @Override
    public String toString() {
        return "Description{" +
                "descriptionText='" + descriptionText + '\'' +
                '}';
    }
}
