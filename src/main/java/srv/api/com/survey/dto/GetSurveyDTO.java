package srv.api.com.survey.dto;

import srv.api.com.question.dto.GetQuestionDTO;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import java.util.ArrayList;
import java.util.List;

public class GetSurveyDTO {

    private SurveyID surveyID;

    private String title;

    private String description;

    private List<GetQuestionDTO> questions;

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GetQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<GetQuestionDTO> questions) {
        this.questions = questions;
    }

    public static GetSurveyDTO createDTOFromSurvey(Survey survey) {
        GetSurveyDTO dto = new GetSurveyDTO();

        dto.surveyID = survey.getSurveyID();
        dto.title = survey.getTitle().getTitleText();
        dto.description = survey.getDescription().getDescriptionText();

        List<GetQuestionDTO> createdQuestionDTOs = new ArrayList<>();
        survey.getQuestions().forEach(question -> {
            createdQuestionDTOs.add(GetQuestionDTO.createDTOFromQuestion(question));
        });
        dto.questions = createdQuestionDTOs;
        return dto;
    }
}
