package srv.api.com.form.domain.model;

import com.sun.istack.NotNull;
import srv.api.com.general.domain.model.BaseEntity;
import srv.api.com.question.domain.model.Question;
import srv.api.com.survey.domain.model.Survey;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * Model class of the Form
 * Extends BaseEntity
 */
@Entity
public class Form extends BaseEntity {

    /**
     * Form's ID
     */
    @Valid
    @Embedded
    @NotNull
    private FormID formID;

    /**
     * Title of Form
     */
    @Valid
    @Embedded
    @NotNull
    private Title title;

    /**
     * Index of Form
     * Lets the client know in what sequence to display the Form's
     */
    @Valid
    @Embedded
    @NotNull
    private Index index;

    /**
     * Question's of the form. Questions hold the answering choices
     */
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Question> questions;

    /**
     * The Survey this Form belongs to
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Survey.class)
    @NotNull
    private Survey survey;

    public FormID getFormID() {
        return formID;
    }

    public void setFormID(FormID formID) {
        this.formID = formID;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Form{" +
                "formID=" + formID +
                ", title=" + title +
                ", index=" + index +
                ", questions=" + questions +
                ", survey=" + survey +
                '}';
    }
}
