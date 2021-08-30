package srv.api.com.question.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
public class Question extends BaseEntity {

    @Valid
    @Embedded
    @NotNull
    private QuestionID questionID;

    @Valid
    @Embedded
    @NotNull
    private QuestionText questionText;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Survey.class)
    @JoinColumn(name="survey_id", nullable = false)
    @NotNull
    private Survey survey;

    @NotNull
    private Boolean multipleAnswer;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AnswerOption> answerOptions;

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

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
