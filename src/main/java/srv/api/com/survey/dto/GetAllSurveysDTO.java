package srv.api.com.survey.dto;

import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

/**
 * DTO class used for handling the Survey in GET requests where we use multiple object instances of the class
 */
public class GetAllSurveysDTO {

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

    @Override
    public String toString() {
        return "GetAllSurveysDTO{" +
                "surveyID=" + surveyID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * Maps the provided Survey to its DTO
     *
     * @param survey the Survey that's mapped
     * @return GetAllSurveyDTO
     */
    public static GetAllSurveysDTO createDTOFromSurvey(Survey survey) {
        GetAllSurveysDTO dto = new GetAllSurveysDTO();

        dto.surveyID = survey.getSurveyID();
        dto.title = survey.getTitle().getText();
        dto.description = survey.getDescription().getText();

        return dto;
    }
}
