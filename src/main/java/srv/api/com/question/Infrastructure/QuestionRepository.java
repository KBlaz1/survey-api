package srv.api.com.question.Infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class QuestionRepository implements PanacheRepository<Question> {

    public Optional<Question> getByID(QuestionID questionID) {
        EntityGraph graph = getEntityManager().getEntityGraph("graph.question.answerOptions");
        return getEntityManager().createNamedQuery(Question.getByID, Question.class)
                .setParameter("question_info_id", questionID.getUUID())
                .setHint("javax.persistence.fetchgraph", graph)
                .getResultStream()
                .findFirst();
    }
}
