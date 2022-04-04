package srv.api.com.answer.Service;

import org.jboss.logging.Logger;
import srv.api.com.answer.domain.model.Answer;
import srv.api.com.answer.infrastructure.AnswerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class AnswerService {

    private static Logger log = Logger.getLogger(AnswerService.class);

    @Inject
    AnswerRepository answerRepository;

    public Answer create(Answer answer) {
        log.info("create() => Creating new answer for survey: " + answer.toString());
        return answerRepository.save(answer);
    }
}
