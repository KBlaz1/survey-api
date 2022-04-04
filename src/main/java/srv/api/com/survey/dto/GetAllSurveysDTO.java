package srv.api.com.survey.dto;

import srv.api.com.survey.domain.model.Survey;

import java.util.UUID;

public class GetAllSurveysDTO {

    private UUID id;

    private String title;

    private String description;

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

    public static GetAllSurveysDTO createDTOFromSurvey(Survey survey) {
        GetAllSurveysDTO dto = new GetAllSurveysDTO();

        dto.id = survey.getSurveyID().getUUID();
        dto.title = survey.getTitle().getTitleText();
        dto.description = survey.getDescription().getDescriptionText();

        return dto;
    }
}
