package srv.api.com.form.dto;

import com.sun.istack.NotNull;
import srv.api.com.form.domain.model.Index;
import srv.api.com.form.domain.model.Form;
import srv.api.com.form.domain.model.FormID;
import srv.api.com.form.domain.model.Title;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.dto.CreateQuestionDTO;
import srv.api.com.survey.domain.model.Survey;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * DTO class for handling the Form class used in POST requests
 */
public class CreateFormDTO {

    /**
     * Form's ID
     */
    @Valid
    @NotNull
    private FormID formID;

    /**
     * Form's title
     */
    @NotNull
    private String title;

    /**
     * Form's index
     */
    @NotNull
    private Integer index;

    /**
     * Form's questions
     */
    @NotNull
    private List<CreateQuestionDTO> questions;

    public FormID getFormID() {
        return formID;
    }

    public void setFormID(FormID formID) {
        this.formID = formID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<CreateQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CreateQuestionDTO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "CreateFormDTO{" +
                "formID=" + formID +
                ", title='" + title + '\'' +
                ", index=" + index +
                ", questions=" + questions +
                '}';
    }

    /**
     * Maps the FormDTO to the Form model class
     *
     * @param survey the survey the form belongs to
     * @return Form class object
     */
    public Form createFormFromDTO(Survey survey) {
        Form form = new Form();

        form.setFormID(FormID.create(UUID.randomUUID()));
        form.setTitle(Title.create(title));
        form.setIndex(Index.create(index));
        form.setSurvey(survey);

        Set<Question> questionsFromDTO = new HashSet<>();
        this.questions.forEach(question -> {
            questionsFromDTO.add(question.createQuestionFromDTO(form));
        });
        form.setQuestions(questionsFromDTO);

        return form;
    }
}
