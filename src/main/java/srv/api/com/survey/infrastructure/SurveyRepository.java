package srv.api.com.survey.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class SurveyRepository implements PanacheRepository<Survey> {

    public Optional<Survey> getByID(SurveyID surveyID) {
        return getEntityManager().createNamedQuery(Survey.getByID, Survey.class)
                .setParameter("survey_info_id", surveyID.getUUID())
                .getResultStream()
                .findFirst();
    }

    public Survey save(Survey survey) {
        if(survey.getEntityId() != null && survey.getSurveyID() != null) {
            return getEntityManager().merge(survey);
        } else {
            getEntityManager().persist(survey);
            return survey;
        }
    }
}
