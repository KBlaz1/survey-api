package srv.api.com.survey.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import srv.api.com.general.domain.model.PageRequest;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SurveyRepository implements PanacheRepository<Survey> {

    public Optional<Survey> getByID(SurveyID surveyID) {
        EntityGraph graph = getEntityManager().getEntityGraph("graph.survey.questions");
        return getEntityManager().createNamedQuery(Survey.getByID, Survey.class)
                .setParameter("survey_info_id", surveyID.getUUID())
                .setHint("javax.persistence.fetchgraph", graph)
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

    public List<Survey> getPaginated(PageRequest pageRequest) {
        List<Survey> surveyList = getEntityManager().createNamedQuery(Survey.getAll, Survey.class)
                .setFirstResult((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize())
                .setMaxResults(pageRequest.getPageSize())
                .getResultList();

        return surveyList;
    }
}
