package srv.api.com.answer.dto;

import srv.api.com.answer.domain.model.Answer;
import srv.api.com.answer.domain.model.AnswerID;
import srv.api.com.answer.domain.model.AnswerText;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class answeredQuestionDTO {

    UUID questionUUID;

    String text;

    Boolean multipleAnswer;

    List<AnswerDTO> answerDTOS;

    public UUID getQuestionUUID() {
        return questionUUID;
    }

    public void setQuestionUUID(UUID questionUUID) {
        this.questionUUID = questionUUID;
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

    public List<AnswerDTO> getAnswerDTOS() {
        return answerDTOS;
    }

    public void setAnswerDTOS(List<AnswerDTO> answerDTOS) {
        this.answerDTOS = answerDTOS;
    }

    public List<Answer> createAnswerFromDTO() {
        List<Answer> answers = new ArrayList<>();

        for(int i = 0; i < answerDTOS.size(); i++) {
            Answer answer = new Answer();
            answer.setText(AnswerText.Create(text));
            answer.setAnswerID(AnswerID.create(UUID.randomUUID()));
            //answer.setQuestion();
        }

        return answers;
    }

    @Override
    public String toString() {
        return "answeredQuestionDTO{" +
                "questionUUID=" + questionUUID +
                ", text='" + text + '\'' +
                ", multipleAnswer=" + multipleAnswer +
                ", answerDTOS=" + answerDTOS +
                '}';
    }
}
