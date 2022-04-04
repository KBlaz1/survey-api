package srv.api.com.answer.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import srv.api.com.answer.domain.model.Answer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnswerRepository implements PanacheRepository<Answer> {

    public Answer save(Answer answer) {
        if(answer.getAnswerID() != null && answer.getEntityId() != null) {
            return getEntityManager().merge(answer);
        } else {
            getEntityManager().persist(answer);
            return answer;
        }
    }

}
