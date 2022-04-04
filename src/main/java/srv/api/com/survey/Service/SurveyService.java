package srv.api.com.survey.Service;

import org.jboss.logging.Logger;
import srv.api.com.general.domain.model.PageRequest;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.infrastructure.SurveyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class SurveyService {

    private static final Logger log = Logger.getLogger(SurveyService.class);

    @Inject
    SurveyRepository surveyRepository;

    public Survey getByID(SurveyID surveyID) {
        log.info("getByID() => Find survey by ID / surveyID = " + surveyID.toString());

        Survey survey = surveyRepository.getByID(surveyID).orElseThrow(() -> new NotFoundException("survey not found."));
        return survey;
    }

    public List<Survey> getAll(PageRequest pageRequest) {
        log.info("getAll() => Finding all parking tasks paginated / pageRequest = " + pageRequest.toString());
        return surveyRepository.getPaginated(pageRequest);
    }

    public Survey create(Survey survey) {
        log.info("create() => creating new survey");
        return surveyRepository.save(survey);
    }

    public long count() {
        log.info("count() => counting the numbers of Surveys");
        return surveyRepository.count();
    }
}
