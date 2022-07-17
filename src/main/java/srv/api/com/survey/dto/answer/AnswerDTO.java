package srv.api.com.survey.dto.answer;

import srv.api.com.survey.domain.model.answer.Answer;
import srv.api.com.survey.domain.model.answer.AnswerID;
import srv.api.com.survey.domain.model.answer.Label;
import srv.api.com.survey.domain.model.choice.ChoiceID;
import srv.api.com.survey.domain.model.question.QuestionID;

import java.util.UUID;

public class AnswerDTO {

    private String label;

    private ChoiceID choiceID;

    private QuestionID questionID;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ChoiceID getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(ChoiceID choiceID) {
        this.choiceID = choiceID;
    }

    public QuestionID getQuestionID() {
        return questionID;
    }

    public void setQuestionID(QuestionID questionID) {
        this.questionID = questionID;
    }

    public Answer createAnswerFromDTO() {
        Answer answer = new Answer();

        answer.setAnswerID(AnswerID.create(UUID.randomUUID()));
        answer.setChoiceID(choiceID);
        answer.setQuestionID(questionID);
        answer.setLabel(Label.Create(label));

        return answer;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "label='" + label + '\'' +
                ", choiceID=" + choiceID +
                ", questionID=" + questionID +
                '}';
    }
}
