package srv.api.com.survey.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import srv.api.com.general.domain.model.PageRequest;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

/**
 * The survey infrastructure
 * Implements PanacheRepository interface for database operations
 */
@ApplicationScoped
public class SurveyRepository implements PanacheRepository<Survey> {

    /**
     * Gets the Survey by it's surveyID
     *
     * @param surveyID Survey's ID
     * @return Optional of Survey
     */
    public Optional<Survey> getByID(SurveyID surveyID) {
        return getEntityManager().createNamedQuery(Survey.getByID, Survey.class)
                .setParameter("survey_info_id", surveyID.getUUID())
                .getResultStream()
                .findFirst();
    }

    /**
     * Persists or updates the provided Survey
     *
     * @param survey contains the Survey's data
     * @return persisted Survey
     */
    public Survey save(Survey survey) {
        if(survey.getEntityId() != null && survey.getSurveyID() != null) {
            return getEntityManager().merge(survey);
        } else {
            getEntityManager().persist(survey);
            return survey;
        }
    }

    /**
     * Gets all Survey's according to page number and size
     *
     * @param pageRequest the pageRequest which contains page number and page size
     * @return List of Survey
     */
    public List<Survey> getPaginated(PageRequest pageRequest) {
        List<Survey> surveyList = getEntityManager().createNamedQuery(Survey.getAll, Survey.class)
                .setFirstResult((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize())
                .setMaxResults(pageRequest.getPageSize())
                .getResultList();

        return surveyList;
    }

    /**
     * Deletes a Survey
     *
     * @param surveyID the Survey's ID
     */
    public void delete(SurveyID surveyID) {
        getEntityManager().remove(getByID(surveyID).orElseThrow());
    }
}
