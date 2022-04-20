package srv.api.com.survey.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import srv.api.com.choice.domain.model.Choice;
import srv.api.com.choice.domain.model.ChoiceID;
import srv.api.com.form.domain.model.Form;
import srv.api.com.form.domain.model.FormID;
import srv.api.com.form.domain.model.Index;
import srv.api.com.question.domain.model.Label;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.question.domain.model.Type;
import srv.api.com.survey.Service.SurveyService;
import srv.api.com.survey.domain.model.Description;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.domain.model.Title;
import srv.api.com.survey.infrastructure.SurveyRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class SurveyServiceTest {

    @Inject
    SurveyRepository surveyRepository;

    @Inject
    SurveyService surveyService;

    @BeforeEach
    void setup() {
        surveyService.create(create());
    }

    @Transactional
    @AfterEach
    void tearDown() {
        deleteTest();
    }

    @Test
    void getByIDTest () {
        // get by ID negative
        assertThrows(NotFoundException.class, () ->
                surveyService.getByID(SurveyID.create(UUID.randomUUID())));
    }

    @Test
    void deleteTest() {
        List<Survey> surveys = surveyRepository.findAll().list();

        surveys.forEach(survey -> surveyService.delete(survey.getSurveyID()));
        assertEquals(0, surveyRepository.findAll().list().size());
    }

    private Survey create() {
        Survey survey = new Survey();

        survey.setSurveyID(SurveyID.create(UUID.randomUUID()));
        survey.setTitle(Title.create("title test"));
        survey.setDescription(Description.create("description test"));
        survey.setTimeStampCreated(LocalDateTime.now());

        Form form = new Form();
        form.setFormID(FormID.create(UUID.randomUUID()));
        form.setTitle(srv.api.com.form.domain.model.Title.create("test form"));
        form.setIndex(Index.create(1));
        form.setSurvey(survey);

        Question question = new Question();
        question.setLabel(Label.create("label test"));
        question.setQuestionID(QuestionID.create(UUID.randomUUID()));
        question.setType(Type.CHECK_BOX);
        question.setRequired(true);
        question.setIndex(srv.api.com.question.domain.model.Index.create(0));
        question.setForm(form);

        Choice choice = new Choice();
        choice.setChoiceID(ChoiceID.create(UUID.randomUUID()));
        choice.setLabel(srv.api.com.choice.domain.model.Label.create("test choice"));
        choice.setIndex(srv.api.com.choice.domain.model.Index.create(0));
        choice.setQuestion(question);

        Set<Choice> choices = new HashSet<>();
        choices.add(choice);
        question.setChoices(choices);

        Set<Question> questions = new HashSet<>();
        questions.add(question);
        form.setQuestions(questions);

        Set<Form> forms = new HashSet<>();
        forms.add(form);
        survey.setForms(forms);

        return survey;
    }
}
