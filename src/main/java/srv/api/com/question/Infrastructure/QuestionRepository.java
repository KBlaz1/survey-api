package srv.api.com.question.Infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import srv.api.com.question.domain.model.Question;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class QuestionRepository implements PanacheRepositoryBase<Question, UUID> {

}
