package srv.api.com.survey.dto;

import srv.api.com.question.domain.model.Question;
import srv.api.com.question.dto.CreateQuestionDTO;
import srv.api.com.survey.domain.model.Description;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.domain.model.Title;

import java.util.*;

public class CreateSurveyDTO {

    private SurveyID surveyID;

    private String title;

    private String description;

    private List<CreateQuestionDTO> questions;

    public SurveyID getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(SurveyID surveyID) {
        this.surveyID = surveyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CreateQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CreateQuestionDTO> questions) {
        this.questions = questions;
    }

    public Survey createSurveyFromDTO() {
        Survey survey = new Survey();
        survey.setSurveyID(SurveyID.create(UUID.randomUUID()));
        survey.setTitle(Title.create(title));
        survey.setDescription(Description.create(description));

        Set<Question> questionsFromDto = new HashSet<>();

        this.questions.forEach(question -> {
            questionsFromDto.add(question.createQuestionFromDTO(survey));
        });
        survey.setQuestions(questionsFromDto);

        return survey;
    }
}
