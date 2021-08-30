package srv.api.com.question.dto;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.dto.CreateAnswerOptionDTO;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.question.domain.model.QuestionText;
import srv.api.com.survey.domain.model.Survey;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateQuestionDTO {

    @Valid
    @NotNull
    private QuestionID questionID;

    @NotNull
    private String questionText;

    @NotNull
    private boolean multipleAnswer;

    @NotNull
    private List<CreateAnswerOptionDTO> answerOptions;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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

    public Question createQuestionFromDTO(Survey survey) {
        Question question = new Question();
        question.setQuestionID(QuestionID.create(UUID.randomUUID()));
        question.setQuestionText(QuestionText.create(questionText));
        question.setMultipleAnswer(multipleAnswer);
        question.setSurvey(survey);
        //dont forget to put question options
        List<AnswerOption> answerOptionsFromDTO = new ArrayList<>();

        this.answerOptions.forEach(option -> {
            answerOptionsFromDTO.add(option.createAnswerOptionFromDTO(question));
        });
        question.setAnswerOptions(answerOptionsFromDTO);

        return question;
    }

}
