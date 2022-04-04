package srv.api.com.answeroption.dto;

import com.sun.istack.NotNull;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.domain.model.AnswerOptionID;
import srv.api.com.answeroption.domain.model.AnswerOptionText;
import srv.api.com.question.domain.model.Question;

import javax.validation.Valid;
import java.util.UUID;

public class CreateAnswerOptionDTO {

    @NotNull
    @Valid
    private AnswerOptionID answerOptionID;

    private String text;

    @NotNull
    private boolean respondentAnswer;

    @NotNull
    private Integer sequenceNumber;

    public AnswerOptionID getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(AnswerOptionID answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

    public boolean isRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(boolean respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public AnswerOption createAnswerOptionFromDTO(Question question) {
        AnswerOption answerOption = new AnswerOption();

        answerOption.setAnswerOptionID(AnswerOptionID.create(UUID.randomUUID()));
        answerOption.setAnswerOptionText(AnswerOptionText.create(text));
        answerOption.setRespondentAnswer(respondentAnswer);
        answerOption.setQuestion(question);
        answerOption.setSequenceNumber(sequenceNumber);

        return answerOption;
    }
}
