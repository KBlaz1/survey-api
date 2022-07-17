package srv.api.com.survey.domain.model.form;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The model class for the Form's index
 * Lets the client know in what sequence to display the forms
 */
@Embeddable
public class Index {

    /**
     * The number of the Form's Index
     */
    @NotNull
    @Column(name = "Index")
    private Integer number;

    public Index() {}

    private Index(Integer number) {
        this.number = number;
    }

    public static Index create(Integer number) {
        return new Index(number);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Index{" +
                "number=" + number +
                '}';
    }
}
