package srv.api.com.question.dto;

import srv.api.com.answeroption.dto.GetAnswerOptionDTO;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.survey.domain.model.SurveyID;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionDTO {

    private QuestionID questionID;

    private SurveyID surveyID;

    private String questionText;

    private Boolean multipleAnswer;

    private List<GetAnswerOptionDTO> answerOptions;

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

    public Boolean getMultipleAnswer() {
        return multipleAnswer;
    }

    public void setMultipleAnswer(Boolean multipleAnswer) {
        this.multipleAnswer = multipleAnswer;
    }

    public List<GetAnswerOptionDTO> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<GetAnswerOptionDTO> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public static GetQuestionDTO createDTOFromQuestion(Question question) {
        GetQuestionDTO dto = new GetQuestionDTO();
        dto.questionID = question.getQuestionID();
        dto.surveyID = question.getSurvey().getSurveyID();
        dto.multipleAnswer = question.getMultipleAnswer();
        dto.questionText = question.getQuestionText().getText();

        List<GetAnswerOptionDTO> createdAnswerOptionDTOs = new ArrayList<>();
        question.getAnswerOptions().forEach(option -> {
            createdAnswerOptionDTOs.add(GetAnswerOptionDTO.createDTOFromAnswerOption(option));
        });
        dto.answerOptions = createdAnswerOptionDTOs;

        return dto;
    }
}
