package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.form.domain.model.Form;
import srv.api.com.general.domain.model.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * Model class of the Survey
 * Extends BaseEntity
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Survey.getAll, query = "SELECT s FROM Survey s"),
        @NamedQuery(name = Survey.getByID, query = "SELECT s from Survey s " +
                "JOIN FETCH s.forms f " +
                "JOIN FETCH f.questions q " +
                "JOIN FETCH q.choices c " +
                "WHERE s.surveyID.uuid = :survey_info_id")
})
public class Survey extends BaseEntity {

    private static final String PREFIX = "Survey";
    public static final String getAll = PREFIX + ".getAll";
    public static final String getByID = PREFIX + ".getByID";

    /**
     * Survey ID
     */
    @Valid
    @Embedded
    @NotNull
    private SurveyID surveyID;

    /**
     * Title of survey
     */
    @Valid
    @Embedded
    @NotNull
    private Title title;

    /**
     * Description of survey
     */
    @Valid
    @Embedded
    private Description description;

    /**
     * Forms of the survey. Forms hold the questions
     */
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Form> forms;

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Set<Form> getForms() {
        return forms;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyID=" + surveyID +
                ", title=" + title +
                ", description=" + description +
                ", forms=" + forms +
                '}';
    }
}
