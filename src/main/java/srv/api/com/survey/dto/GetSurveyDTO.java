package srv.api.com.survey.dto;

import srv.api.com.form.domain.model.Form;
import srv.api.com.form.dto.GetFormDTO;
import srv.api.com.question.dto.GetQuestionDTO;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * DTO class for handling the Survey class used in GET requests
 */
public class GetSurveyDTO {

    /**
     * Survey's ID
     */
    private SurveyID surveyID;

    /**
     * Survey's title
     */
    private String title;

    /**
     * Survey's description
     */
    private String description;

    /**
     * Survey's forms
     */
    private List<GetFormDTO> forms;

    private LocalDateTime timeStampCreated;

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

    public List<GetFormDTO> getForms() {
        return forms;
    }

    public void setForms(List<GetFormDTO> forms) {
        this.forms = forms;
    }

    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(LocalDateTime timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    @Override
    public String toString() {
        return "GetSurveyDTO{" +
                "surveyID=" + surveyID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", forms=" + forms +
                ", timeStampCreated=" + timeStampCreated +
                '}';
    }

    /**
     * Maps the Survey to its dto
     *
     * @param survey the survey that's mapped
     * @return GetSurveyDTO
     */
    public static GetSurveyDTO createDTOFromSurvey(Survey survey) {
        GetSurveyDTO dto = new GetSurveyDTO();

        dto.surveyID = survey.getSurveyID();
        dto.title = survey.getTitle().getText();
        dto.description = survey.getDescription().getText();
        dto.timeStampCreated = survey.getTimeStampCreated();

        List<GetFormDTO> createdGetFormDTOs = new ArrayList<>();
        survey.getForms().forEach(form -> {
            createdGetFormDTOs.add(GetFormDTO.createDTOFromForm(form));
        });
        dto.forms = createdGetFormDTOs;

        return dto;
    }
}
