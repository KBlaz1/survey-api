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

    private String answerOptionText;

    @NotNull
    private boolean respondentAnswer;

    public AnswerOptionID getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(AnswerOptionID answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

    public String getAnswerOptionText() {
        return answerOptionText;
    }

    public void setAnswerOptionText(String answerOptionText) {
        this.answerOptionText = answerOptionText;
    }

    public boolean isRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(boolean respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public AnswerOption createAnswerOptionFromDTO(Question question) {
        AnswerOption answerOption = new AnswerOption();

        answerOption.setAnswerOptionID(AnswerOptionID.create(UUID.randomUUID()));
        answerOption.setAnswerOptionText(AnswerOptionText.create(answerOptionText));
        answerOption.setRespondentAnswer(respondentAnswer);
        answerOption.setQuestion(question);

        return answerOption;
    }
}
