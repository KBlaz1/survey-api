package srv.api.com.answer.boundary;

import srv.api.com.answer.Service.AnswerService;
import srv.api.com.answer.dto.AnsweredSurveyDTO;
import srv.api.com.answer.dto.CreateAnswerDTO;
import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.question.service.QuestionService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("answer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnswerResource {

    @Inject
    AnswerService answerService;

    @Inject
    QuestionService questionService;

    @POST
    public Response createAnswer(List<CreateAnswerDTO> answerDTOS) {


        //Question question = questionService.getByID(QuestionID.create(answerD))

        return Response.ok().build();
    }

    @POST
    public Response answerSurvey(AnsweredSurveyDTO answeredSurveyDTO) {



        return Response.ok().build();
    }
}
