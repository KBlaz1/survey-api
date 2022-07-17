package srv.api.com.survey.dto.question;

import com.sun.istack.NotNull;
import srv.api.com.survey.domain.model.choice.Choice;
import srv.api.com.survey.domain.model.form.Form;
import srv.api.com.survey.domain.model.question.*;
import srv.api.com.survey.dto.choice.CreateChoiceDTO;

import javax.validation.Valid;
import java.util.*;

/**
 * DTO class for handling the Question class used in POST requests
 */
public class CreateQuestionDTO {

    /**
     * Question's ID
     */
    @Valid
    @NotNull
    private QuestionID questionID;

    /**
     * Question's label
     */
    @NotNull
    private String label;

    /**
     * Type of the Question
     */
    @NotNull
    private String type;

    /**
     * Question's index
     */
    @NotNull
    private Integer index;

    /**
     * determines if the question needs to be answered
     */
    @NotNull
    private Boolean isRequired;

    /**
     * Question's answering choices
     */
    @NotNull
    private List<CreateChoiceDTO> choices;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public List<CreateChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<CreateChoiceDTO> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "CreateQuestionDTO{" +
                "questionID=" + questionID +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", index=" + index +
                ", isRequired=" + isRequired +
                ", choices=" + choices +
                '}';
    }

    /**
     * Maps the QuestionDTO to the Question model class
     *
     * @param form the form the question belongs to
     * @return Form class object
     */
    public Question createQuestionFromDTO(Form form) {
        Question question = new Question();

        question.setQuestionID(QuestionID.create(UUID.randomUUID()));
        question.setLabel(Label.create(label));
        question.setType(Type.valueOf(type));
        question.setIndex(Index.create(index));
        question.setRequired(isRequired);
        question.setForm(form);

        Set<Choice> choicesFromDTO = new HashSet<>();
        this.choices.forEach(choice -> {
            choicesFromDTO.add(choice.createChoiceFromDTO(question));
        });
        question.setChoices(choicesFromDTO);

        return question;
    }

}
