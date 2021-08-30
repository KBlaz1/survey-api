package srv.api.com.answeroption.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.question.domain.model.Question;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class AnswerOption extends BaseEntity {

    @NotNull
    @Embedded
    @Valid
    private AnswerOptionID answerOptionID;

    @Embedded
    private AnswerOptionText answerOptionText;

    //tells us if the answer was made by the creator of the survey or the responded
    @NotNull
    private Boolean respondentAnswer;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinColumn(name="question_id", nullable = false)
    private Question question;

    public AnswerOptionID getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(AnswerOptionID answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

    public AnswerOptionText getAnswerOptionText() {
        return answerOptionText;
    }

    public void setAnswerOptionText(AnswerOptionText answerOptionText) {
        this.answerOptionText = answerOptionText;
    }

    public Boolean isRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(Boolean respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
