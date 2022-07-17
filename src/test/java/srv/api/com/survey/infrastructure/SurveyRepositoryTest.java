package srv.api.com.survey.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import srv.api.com.general.domain.model.PageRequest;
import srv.api.com.survey.domain.model.Description;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.domain.model.Title;
import srv.api.com.survey.domain.model.choice.Choice;
import srv.api.com.survey.domain.model.choice.ChoiceID;
import srv.api.com.survey.domain.model.form.Form;
import srv.api.com.survey.domain.model.form.FormID;
import srv.api.com.survey.domain.model.form.Index;
import srv.api.com.survey.domain.model.question.Label;
import srv.api.com.survey.domain.model.question.Question;
import srv.api.com.survey.domain.model.question.QuestionID;
import srv.api.com.survey.domain.model.question.Type;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Transactional
public class SurveyRepositoryTest {

    @Inject
    SurveyRepository surveyRepository;

    @BeforeEach
    void setup() {
        surveyRepository.persist(create());
        surveyRepository.persist(create());
        surveyRepository.persist(create());
        surveyRepository.persist(create());
    }

    @AfterEach
    void tearDown() {
        deleteTest();
    }

    @Test
    void getPaginatedTest() {
        final List<Survey> firstPage = surveyRepository.getPaginated(PageRequest.create(1, 2));
        final List<Survey> secondPage = surveyRepository.getPaginated(PageRequest.create(2, 2));
        final List<Survey> invalidPage = surveyRepository.getPaginated(PageRequest.create(3,5));
        final List<Survey> allInOnePage = surveyRepository.getPaginated(PageRequest.create(1,6));

        assertEquals(2, firstPage.size());
        assertEquals(2, secondPage.size());
        assertEquals(surveyRepository.count(), firstPage.size() + secondPage.size());
        assertEquals(0, invalidPage.size());
        assertEquals(4, allInOnePage.size());
    }

    @Test
    void getByIDTest() {
        final long count = surveyRepository.count();
        final List<Survey> surveys = surveyRepository.listAll();
        assertEquals(count, surveys.size());
        surveys
                .forEach(survey ->
                        assertTrue(surveyRepository.getByID((survey.getSurveyID())).isPresent()));
    }

    @Test
    void deleteTest() {
        final long count = surveyRepository.count();

        final List<Survey> surveys = surveyRepository.listAll();
        assertEquals(count, surveys.size());
        surveys
                .forEach(survey -> surveyRepository.delete(survey.getSurveyID()));
        assertEquals(0, surveyRepository.count());
    }

    @Test
    void updateTest() {
        final long count = surveyRepository.count();

        final List<Survey> surveys = surveyRepository.listAll();
        assertEquals(count, surveys.size());
        surveys
                .forEach(survey -> {
                    survey.setTitle(Title.create("updated title"));
                    Survey updatedSurvey = surveyRepository.save(survey);
                    assertEquals(survey.getTitle().getText(), "updated title");
                    assertEquals(survey, updatedSurvey);
                });
    }

    private Survey create() {
        Survey survey = new Survey();

        survey.setSurveyID(SurveyID.create(UUID.randomUUID()));
        survey.setTitle(Title.create("title test"));
        survey.setDescription(Description.create("description test"));
        survey.setTimeStampCreated(LocalDateTime.now());

        Form form = new Form();
        form.setFormID(FormID.create(UUID.randomUUID()));
        form.setTitle(srv.api.com.survey.domain.model.form.Title.create("test form"));
        form.setIndex(Index.create(1));
        form.setSurvey(survey);

        Question question = new Question();
        question.setLabel(Label.create("label test"));
        question.setQuestionID(QuestionID.create(UUID.randomUUID()));
        question.setType(Type.CHECK_BOX);
        question.setRequired(true);
        question.setIndex(srv.api.com.survey.domain.model.question.Index.create(0));
        question.setForm(form);

        Choice choice = new Choice();
        choice.setChoiceID(ChoiceID.create(UUID.randomUUID()));
        choice.setLabel(srv.api.com.survey.domain.model.choice.Label.create("test choice"));
        choice.setIndex(srv.api.com.survey.domain.model.choice.Index.create(0));
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
