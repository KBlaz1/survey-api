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

    /**
     * Finds a Survey by its UUID
     *
     * @param surveyID the unique SurveyID
     * @return Survey
     * @Throws NotFoundException throws NotFoundException for Survey
     */
    public Survey getByID(SurveyID surveyID) {
        log.info("getByID() => Find survey by ID / surveyID = " + surveyID.toString());
        return surveyRepository.getByID(surveyID).orElseThrow(() -> new NotFoundException("survey not found."));
    }

    /**
     * Gets a paginates list of filtered Surveys
     *
     * @param pageRequest filter parameters
     * @return List of Survey
     */
    public List<Survey> getAll(PageRequest pageRequest) {
        log.info("getAll() => Finding all parking tasks paginated / pageRequest = " + pageRequest.toString());
        return surveyRepository.getPaginated(pageRequest);
    }

    /**
     * Saves a Survey
     *
     * @param survey the Survey that's saved
     * @return persisted Survey
     */
    public Survey create(Survey survey) {
        log.info("create() => creating new survey");
        return surveyRepository.save(survey);
    }

    /**
     * Checks if a Survey exists in the database
     *
     * @param surveyID Survey's SurveyID
     * @return true if customer exists, false if not
     */
    public boolean checkSurvey(SurveyID surveyID) {
        log.info("checkSurvey() => Checking for survey / SurveyID = " + surveyID.toString());
        return surveyRepository.getByID(surveyID).isPresent();
    }

    /**
     * counts the number of Surveys in the database
     *
     * @return number of Surveys
     */
    public long count() {
        log.info("count() => counting the numbers of Surveys");
        return surveyRepository.count();
    }
}
