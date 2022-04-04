package srv.api.com.survey.dto;

import srv.api.com.question.dto.GetQuestionDTO;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GetSurveyDTO {

    private UUID id;

    private String title;

    private String description;

    private List<GetQuestionDTO> questions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

        dto.id = survey.getSurveyID().getUUID();
        dto.title = survey.getTitle().getTitleText();
        dto.description = survey.getDescription().getDescriptionText();

        List<GetQuestionDTO> createdGetQuestionDTOs = new ArrayList<>();
        survey.getQuestions().forEach(question -> {
            createdGetQuestionDTOs.add(GetQuestionDTO.createDTOFromQuestion(question));
        });
        dto.questions = createdGetQuestionDTOs;
        return dto;
    }
}
