package srv.api.com.survey.dto.choice;

import com.sun.istack.NotNull;
import srv.api.com.survey.domain.model.choice.Choice;
import srv.api.com.survey.domain.model.choice.ChoiceID;
import srv.api.com.survey.domain.model.choice.Index;
import srv.api.com.survey.domain.model.choice.Label;
import srv.api.com.survey.domain.model.question.Question;

import javax.validation.Valid;
import java.util.UUID;

/**
 * DTO class for handling the Choice class used in POST requests
 */
public class CreateChoiceDTO {

    /**
     * Choice's ID
     */
    @Valid
    @NotNull
    private ChoiceID choiceID;

    /**
     * Choice's label
     */
    @NotNull
    private String label;

    /**
     * Choice's index
     */
    @NotNull
    private Integer index;

    public ChoiceID getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(ChoiceID choiceID) {
        this.choiceID = choiceID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "CreateChoiceDTO{" +
                "choiceID=" + choiceID +
                ", label='" + label + '\'' +
                ", index=" + index +
                '}';
    }

    /**
     * Maps the ChoiceDTO to the Choice model class
     *
     * @param question the question the form belongs to
     * @return Choice class object
     */
    public Choice createChoiceFromDTO(Question question) {
        Choice choice = new Choice();

        choice.setChoiceID(ChoiceID.create(UUID.randomUUID()));
        choice.setLabel(Label.create(label));
        choice.setIndex(Index.create(index));
        choice.setQuestion(question);

        return choice;
    }
}
