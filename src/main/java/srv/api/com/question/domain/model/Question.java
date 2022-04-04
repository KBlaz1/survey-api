package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Question.getByID, query = "SELECT q FROM Question q where q.questionID.uuid = :question_info_id")
})
@Entity
public class Question extends BaseEntity {

    public static final String PREFIX = "Question";
    public static final String getByID = PREFIX + ".getByID";

    @Valid
    @Embedded
    @NotNull
    private QuestionID questionID;

    @Valid
    @Embedded
    @NotNull
    private QuestionText questionText;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Survey.class)
    @NotNull
    private Survey survey;

    @NotNull
    private Boolean multipleAnswer;

    @NotNull
    Integer sequenceNumber;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<AnswerOption> answerOptions;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public QuestionText getQuestionText() {
        return questionText;
    }

    public void setQuestionText(QuestionText questionText) {
        this.questionText = questionText;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Boolean getMultipleAnswer() {
        return multipleAnswer;
    }

    public void setMultipleAnswer(Boolean multipleAnswer) {
        this.multipleAnswer = multipleAnswer;
    }

    public Set<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(Set<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", questionText=" + questionText +
                ", survey=" + survey +
                ", multipleAnswer=" + multipleAnswer +
                ", sequenceNumber=" + sequenceNumber +
                ", answerOptions=" + answerOptions +
                '}';
    }
}
