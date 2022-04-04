package srv.api.com.question.dto;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.dto.CreateAnswerOptionDTO;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.question.domain.model.QuestionText;
import srv.api.com.survey.domain.model.Survey;

import javax.validation.Valid;
import java.util.*;

public class CreateQuestionDTO {

    @Valid
    @NotNull
    private QuestionID questionID;

    @NotNull
    private String text;

    @NotNull
    private boolean multipleAnswer;

    @NotNull
    private List<CreateAnswerOptionDTO> answerOptions;

    @NotNull
    private Integer sequenceNumber;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public String geText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMultipleAnswer() {
        return multipleAnswer;
    }

    public void setMultipleAnswer(boolean multipleAnswer) {
        this.multipleAnswer = multipleAnswer;
    }

    public List<CreateAnswerOptionDTO> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<CreateAnswerOptionDTO> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String getText() {
        return text;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Question createQuestionFromDTO(Survey survey) {
        Question question = new Question();
        question.setQuestionID(QuestionID.create(UUID.randomUUID()));
        question.setQuestionText(QuestionText.create(text));
        question.setMultipleAnswer(multipleAnswer);
        question.setSurvey(survey);
        question.setSequenceNumber(sequenceNumber);

        Set<AnswerOption> answerOptionsFromDTO = new HashSet<>();

        this.answerOptions.forEach(option -> {
            answerOptionsFromDTO.add(option.createAnswerOptionFromDTO(question));
        });
        question.setAnswerOptions(answerOptionsFromDTO);

        return question;
    }

}
