package srv.api.com.question.boundary;

import srv.api.com.question.domain.model.Question;
import srv.api.com.question.domain.model.QuestionID;
import srv.api.com.question.service.QuestionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.UUID;

@Path("question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResrource {

    @Inject
    QuestionService questionService;

    //Todo: change the UUID parameter to QuestionID object
    @GET
    @Path("{QuestionID}")
    public Response getByID(@PathParam("QuestionID") UUID uuid) {
        Question question = questionService.getByID(QuestionID.create(uuid));

        return Response.ok(question).build();
    }
}
