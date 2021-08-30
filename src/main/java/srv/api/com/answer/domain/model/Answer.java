package srv.api.com.answer.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.question.domain.model.Question;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Answer extends BaseEntity {

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
}
