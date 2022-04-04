package srv.api.com.answeroption.dto;

import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.domain.model.AnswerOptionID;
import srv.api.com.question.domain.model.QuestionID;

import java.util.UUID;

public class GetAnswerOptionDTO {

    private UUID id;

    private String text;

    private Boolean respondentAnswer;

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

    public Boolean getRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(Boolean respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public static GetAnswerOptionDTO createDTOFromAnswerOption(AnswerOption answerOption) {
        GetAnswerOptionDTO dto = new GetAnswerOptionDTO();
        dto.id = answerOption.getAnswerOptionID().getUUID();
        dto.text = answerOption.getAnswerOptionText().getText();
        dto.respondentAnswer = answerOption.isRespondentAnswer();
        dto.sequenceNumber = answerOption.getSequenceNumber();

        return dto;
    }
}
