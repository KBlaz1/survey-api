package srv.api.com.survey.domain.model.choice;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.survey.domain.model.question.Question;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Model class of the Choice
 * Extends BaseEntity
 */
@Entity
public class Choice extends BaseEntity {

    /**
     * Choice's ID
     */
    @Valid
    @Embedded
    @NotNull
    private ChoiceID choiceID;

    /**
     * Label of Choice
     */
    @Valid
    @Embedded
    @NotNull
    private Label label;

    /**
     * Index of Choice
     * Lets the client know in what sequence to display the Choice's
     */
    @Valid
    @Embedded
    @NotNull
    private Index index;

    /**
     * Question this Choice belongs to
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Question.class)
    @JoinColumn(name="question_id", nullable = false)
    private Question question;

    public ChoiceID getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(ChoiceID choiceID) {
        this.choiceID = choiceID;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public srv.api.com.survey.domain.model.choice.Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choiceID=" + choiceID +
                ", label=" + label +
                ", index=" + index +
                ", question=" + question +
                '}';
    }
}
