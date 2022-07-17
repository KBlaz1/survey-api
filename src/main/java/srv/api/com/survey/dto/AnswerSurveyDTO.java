package srv.api.com.survey.dto;

import srv.api.com.survey.domain.model.answer.Answer;
import srv.api.com.survey.dto.answer.AnswerDTO;
import srv.api.com.survey.domain.model.SurveyID;

import java.util.LinkedList;
import java.util.List;

public class AnswerSurveyDTO {

    private SurveyID surveyID;

    private List<AnswerDTO> answers;

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public List<Answer> answersFromDTO() {
        List<Answer> answerList = new LinkedList<>();
        answers.forEach(answerDTO -> answerList.add(answerDTO.createAnswerFromDTO()));
        return answerList;
    }

    @Override
    public String toString() {
        return "AnswerSurveyDTO{" +
                "surveyID=" + surveyID +
                ", answers=" + answers +
                '}';
    }
}
