package srv.api.com.answer.dto;

import srv.api.com.answer.domain.model.Answer;
import srv.api.com.survey.domain.model.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnsweredSurveyDTO {

    /**
    UUID surveyUUID;

    List<answeredQuestionDTO> answeredQuestionDTOS;

    public UUID getSurveyUUID() {
        return surveyUUID;
    }

    public void setSurveyUUID(UUID surveyUUID) {
        this.surveyUUID = surveyUUID;
    }

    public List<answeredQuestionDTO> getAnsweredQuestionDTOS() {
        return answeredQuestionDTOS;
    }

    public void setAnsweredQuestionDTOS(List<answeredQuestionDTO> answeredQuestionDTOS) {
        this.answeredQuestionDTOS = answeredQuestionDTOS;
    }

    public List<Answer> createAnswersFromDTO() {
        List<Answer> answers = new ArrayList<>();

        for(int i = 0; i < answeredQuestionDTOS.size(); i++) {

        }

        return answers;
    }

    @Override
    public String toString() {
        return "AnswerSurveyDTO{" +
                "surveyUUID=" + surveyUUID +
                ", answeredQuestionDTOS=" + answeredQuestionDTOS +
                '}';
    }*/
}
