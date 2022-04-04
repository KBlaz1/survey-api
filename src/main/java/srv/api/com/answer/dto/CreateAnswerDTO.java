package srv.api.com.answer.dto;

import srv.api.com.answer.domain.model.Answer;
import srv.api.com.answer.domain.model.AnswerID;
import srv.api.com.answer.domain.model.AnswerText;
import srv.api.com.answeroption.domain.model.AnswerOption;
import srv.api.com.answeroption.domain.model.AnswerOptionID;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;

import java.util.UUID;

public class CreateAnswerDTO {

    private UUID answerID;

    private UUID answerOptionID;

    private UUID questionID;

    private String text;

    public UUID getAnswerID() {
        return answerID;
    }

    public void setAnswerID(UUID answerID) {
        this.answerID = answerID;
    }

    public UUID getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(UUID answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

    public UUID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(UUID questionID) {
        this.questionID = questionID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer createAnswerFromDTO() {
        Answer answer = new Answer();
        answer.setAnswerID(AnswerID.create(UUID.randomUUID()));
        answer.setText(AnswerText.Create(text));


        return answer;
    }

    @Override
    public String toString() {
        return "CreateAnswerDTO{" +
                "answerID=" + answerID +
                ", answerOptionID=" + answerOptionID +
                ", questionID=" + questionID +
                ", text='" + text + '\'' +
                '}';
    }
}
