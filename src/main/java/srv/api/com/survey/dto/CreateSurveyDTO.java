package srv.api.com.survey.dto;

import com.sun.istack.NotNull;
import srv.api.com.form.domain.model.Form;
import srv.api.com.form.dto.CreateFormDTO;
import srv.api.com.survey.domain.model.Description;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.domain.model.Title;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

/**
 * DTO class for handling the Survey class used in POST requests
 */
public class CreateSurveyDTO {

    /**
     * Survey's ID
     */
    @Valid
    @NotNull
    private SurveyID surveyID;

    /**
     * Survey's title
     */
    @NotNull
    private String title;

    /**
     * Survey's description
     */
    @NotNull
    private String description;

    /**
     * Survey's forms
     */
    @NotNull
    private List<CreateFormDTO> forms;

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

    public List<CreateFormDTO> getForms() {
        return forms;
    }

    public void setForms(List<CreateFormDTO> forms) {
        this.forms = forms;
    }

    @Override
    public String toString() {
        return "CreateSurveyDTO{" +
                "surveyID=" + surveyID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", forms=" + forms +
                '}';
    }

    /**
     * Maps the SurveyDTO to the Survey model class
     *
     * @return Survey class object
     */
    public Survey createSurveyFromDTO() {
        Survey survey = new Survey();

        survey.setSurveyID(SurveyID.create(UUID.randomUUID()));
        survey.setTitle(Title.create(title));
        survey.setDescription(Description.create(description));
        survey.setTimeStampCreated(LocalDateTime.now());

        Set<Form> formsFromDTO = new HashSet<>();
        this.forms.forEach(form -> {
            formsFromDTO.add(form.createFormFromDTO(survey));
        });
        survey.setForms(formsFromDTO);

        return survey;
    }
}
