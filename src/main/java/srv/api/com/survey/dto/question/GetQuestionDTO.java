package srv.api.com.survey.dto.question;

import srv.api.com.survey.domain.model.question.Question;
import srv.api.com.survey.domain.model.question.QuestionID;
import srv.api.com.survey.dto.choice.GetChoiceDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for handling the Question class used in GET requests
 */
public class GetQuestionDTO {

    /**
     * Question's ID
     */
    private QuestionID questionID;

    /**
     * Question's label
     */
    private String label;

    /**
     * Question's type
     */
    private String type;

    /**
     * Question's index
     */
    private Integer index;

    /**
     * Question's isRequired
     */
    private Boolean isRequired;

    /**
     * Question's choices
     */
    private List<GetChoiceDTO> choices;

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public List<GetChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<GetChoiceDTO> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "GetQuestionDTO{" +
                "questionID=" + questionID +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", index=" + index +
                ", isRequired=" + isRequired +
                ", choices=" + choices +
                '}';
    }

    /**
     * Maps the Question to its dto
     *
     * @param question The question that's mapped
     * @return GetQuestionDTO
     */
    public static GetQuestionDTO createDTOFromQuestion(Question question) {
        GetQuestionDTO dto = new GetQuestionDTO();

        dto.questionID = question.getQuestionID();
        dto.type = question.getType().toString();
        dto.label = question.getLabel().getText();
        dto.index = question.getIndex().getNumber();
        dto.isRequired = question.getRequired();

        List<GetChoiceDTO> createdGetChoiceDTOS = new ArrayList<>();
        question.getChoices().forEach(choice -> {
            createdGetChoiceDTOS.add(GetChoiceDTO.createDTOFromChoice(choice));
        });
        dto.choices = createdGetChoiceDTOS;

        return dto;
    }
}
