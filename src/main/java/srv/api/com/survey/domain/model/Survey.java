package srv.api.com.survey.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.form.domain.model.Form;
import srv.api.com.general.domain.model.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Objects;
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

    @NotNull
    private LocalDateTime timeStampCreated;

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

    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(LocalDateTime timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyID=" + surveyID +
                ", title=" + title +
                ", description=" + description +
                ", timeStampCreated=" + timeStampCreated +
                ", forms=" + forms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(surveyID, survey.surveyID) &&
                Objects.equals(title, survey.title) &&
                Objects.equals(description, survey.description) &&
                Objects.equals(timeStampCreated, survey.timeStampCreated) &&
                Objects.equals(forms, survey.forms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyID, title, description, timeStampCreated, forms);
    }
}
