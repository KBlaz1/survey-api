package srv.api.com.question.service;

import org.hibernate.annotations.NotFound;
import srv.api.com.question.Infrastructure.QuestionRepository;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@Transactional
@ApplicationScoped
public class QuestionService {

    @Inject
    QuestionRepository questionRepository;

    public Question getByID(QuestionID questionID) {
        Question question = questionRepository.getByID(questionID).orElseThrow(() -> new NotFoundException("question not found."));
        return question;
    }
}
