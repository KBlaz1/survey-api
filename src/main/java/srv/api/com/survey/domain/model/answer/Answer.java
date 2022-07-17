package srv.api.com.survey.domain.model.answer;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.survey.domain.model.choice.ChoiceID;
import srv.api.com.survey.domain.model.question.QuestionID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;

@Entity
@NamedQueries({
        @NamedQuery(name = Answer.getAll, query = "SELECT a FROM Answer a"),
        @NamedQuery(name = Answer.getByID, query = "SELECT a FROM Answer a where a.answerID.uuid = :answer_info_id")
})
public class Answer extends BaseEntity {

    private static final String PREFIX = "Answer";
    public static final String getAll = PREFIX + ".getAll";
    public static final String getByID = PREFIX + ".getByID";

    @Valid
    @Embedded
    @NotNull
    private AnswerID answerID;

    @Valid
    @Embedded
    @NotNull
    private ChoiceID choiceID;

    @Valid
    @Embedded
    @NotNull
    private QuestionID questionID;

    @NotNull
    @Embedded
    private Label label;

    public AnswerID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(AnswerID answerID) {
        this.answerID = answerID;
    }

    public ChoiceID getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(ChoiceID choiceID) {
        this.choiceID = choiceID;
    }

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

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", choiceID=" + choiceID +
                ", questionID=" + questionID +
                ", label=" + label +
                '}';
    }
}
