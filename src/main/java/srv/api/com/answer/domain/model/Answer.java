package srv.api.com.answer.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.question.domain.model.Question;

import javax.persistence.*;
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

    @NotNull
    @OneToOne
    @JoinColumn(name = "answeroption_id")
    private AnswerOption answerOption;

    @NotNull
    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @NotNull
    @Embedded
    private AnswerText text;

    public AnswerID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(AnswerID answerID) {
        this.answerID = answerID;
    }

    public AnswerOption getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOption answerOption) {
        this.answerOption = answerOption;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerText getText() {
        return text;
    }

    public void setText(AnswerText text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", answerOption=" + answerOption +
                ", question=" + question +
                ", text=" + text +
                '}';
    }
}
