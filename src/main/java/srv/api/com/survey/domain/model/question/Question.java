package srv.api.com.survey.domain.model.question;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.survey.domain.model.choice.Choice;
import srv.api.com.survey.domain.model.form.Form;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * Model class of the Question
 * Extends BaseEntity
 */
@Entity
public class Question extends BaseEntity {

    public static final String PREFIX = "Question";
    public static final String getByID = PREFIX + ".getByID";

    /**
     * Question ID
     */
    @Valid
    @Embedded
    @NotNull
    private QuestionID questionID;

    /**
     * Label of Question
     */
    @Valid
    @Embedded
    @NotNull
    private Label label;

    /**
     * Type of Question
     * Lets the client know how to display the Question
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    /**
     * Index of Question
     * Lets the client know in what sequence to display the Question's
     */
    @Valid
    @Embedded
    @NotNull
    private Index index;

    /**
     * Is the answering of the question required?
     */
    @NotNull
    private Boolean isRequired;

    /**
     * The Form this Question belongs to
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Form.class)
    @NotNull
    private Form form;

    /**
     * Choices for answering the question
     */
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Choice> choices;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", label=" + label +
                ", type=" + type +
                ", index=" + index +
                ", isRequired=" + isRequired +
                ", form=" + form +
                ", choices=" + choices +
                '}';
    }
}
