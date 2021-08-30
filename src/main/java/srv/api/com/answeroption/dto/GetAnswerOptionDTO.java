package srv.api.com.answeroption.dto;

import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.domain.model.AnswerOptionID;
import srv.api.com.question.domain.model.QuestionID;

public class GetAnswerOptionDTO {

    private AnswerOptionID answerOptionID;

    private String answerOptionText;

    private Boolean respondentAnswer;

    private QuestionID questionID;

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

    public Boolean getRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(Boolean respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public static GetAnswerOptionDTO createDTOFromAnswerOption(AnswerOption answerOption) {
        GetAnswerOptionDTO dto = new GetAnswerOptionDTO();
        dto.answerOptionID = answerOption.getAnswerOptionID();
        dto.answerOptionText = answerOption.getAnswerOptionText().getText();
        dto.respondentAnswer = answerOption.isRespondentAnswer();
        dto.questionID = answerOption.getQuestion().getQuestionID();

        return dto;
    }
}
