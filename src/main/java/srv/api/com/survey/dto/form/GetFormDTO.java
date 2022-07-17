package srv.api.com.survey.dto.form;

import srv.api.com.survey.domain.model.form.Form;
import srv.api.com.survey.domain.model.form.FormID;
import srv.api.com.survey.dto.question.GetQuestionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for handling the Form class used in GET requests
 */
public class GetFormDTO {

    /**
     * Form's ID
     */
    private FormID formID;

    /**
     * Form's title
     */
    private String title;

    /**
     * Form's index
     */
    private Integer index;

    /**
     * Form's questions
     */
    private List<GetQuestionDTO> questions;

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

    public List<GetQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<GetQuestionDTO> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "GetFormDTO{" +
                "formID=" + formID +
                ", title='" + title + '\'' +
                ", index=" + index +
                ", questions=" + questions +
                '}';
    }

    /**
     * Maps the Form to its dto
     *
     * @param form The form that's mapped
     * @return GetFormDTO
     */
    public static GetFormDTO createDTOFromForm(Form form) {
        GetFormDTO dto = new GetFormDTO();

        dto.formID = form.getFormID();
        dto.title = form.getTitle().getText();
        dto.index = form.getIndex().getNumber();

        List<GetQuestionDTO> createdGetQuestionDTOs = new ArrayList<>();
        form.getQuestions().forEach(question -> {
            createdGetQuestionDTOs.add(GetQuestionDTO.createDTOFromQuestion(question));
        });
        dto.questions = createdGetQuestionDTOs;

        return dto;
    }
}
