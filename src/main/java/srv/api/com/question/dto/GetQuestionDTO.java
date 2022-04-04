package srv.api.com.question.dto;

import srv.api.com.answeroption.dto.GetAnswerOptionDTO;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.survey.domain.model.SurveyID;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GetQuestionDTO {

    private UUID id;

    private String text;

    private Boolean multipleAnswer;

    private List<GetAnswerOptionDTO> answerOptions;

    private Integer sequenceNumber;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getMultipleAnswer() {
        return multipleAnswer;
    }

    public void setMultipleAnswer(Boolean multipleAnswer) {
        this.multipleAnswer = multipleAnswer;
    }

    public List<GetAnswerOptionDTO> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<GetAnswerOptionDTO> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public static GetQuestionDTO createDTOFromQuestion(Question question) {
        GetQuestionDTO dto = new GetQuestionDTO();
        dto.id = question.getQuestionID().getUUID();
        dto.multipleAnswer = question.getMultipleAnswer();
        dto.text = question.getQuestionText().getText();
        dto.sequenceNumber = question.getSequenceNumber();

        List<GetAnswerOptionDTO> createdGetAnswerOptionDTOs = new ArrayList<>();
        question.getAnswerOptions().forEach(option -> {
            createdGetAnswerOptionDTOs.add(GetAnswerOptionDTO.createDTOFromAnswerOption(option));
        });
        dto.answerOptions = createdGetAnswerOptionDTOs;

        return dto;
    }
}
