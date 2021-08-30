package srv.api.com.survey.Service;

import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.infrastructure.SurveyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class SurveyService {

    @Inject
    SurveyRepository surveyRepository;

    public Survey getByID(SurveyID surveyID) {
        Survey survey = surveyRepository.getByID(surveyID).orElseThrow(() -> new NotFoundException("survey not found."));
        return survey;
    }

    public Survey create(Survey survey) {
        return surveyRepository.save(survey);
    }
}
