package srv.api.com.survey.boundary;

import srv.api.com.survey.Service.SurveyService;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.dto.CreateSurveyDTO;
import srv.api.com.survey.dto.GetSurveyDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("survey")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class SurveyResource {

    @Inject
    SurveyService surveyService;

    @GET
    public Response getByID(@PathParam("SurveyID") SurveyID surveyID) {

        Survey survey = surveyService.getByID(surveyID);

        return Response.ok(GetSurveyDTO.createDTOFromSurvey(survey)).build();
    }

    @POST
    public Response createSurvey(@Valid CreateSurveyDTO createSurveyDTO, @Context UriInfo uriInfo) {

        //todo: respons status 409 if id already exists

        Survey survey = createSurveyDTO.createSurveyFromDTO();
        survey = surveyService.create(createSurveyDTO.createSurveyFromDTO());

        return Response.created(uriInfo.getRequestUriBuilder()
            .path(
                    survey.getSurveyID().getUUID().toString()
            ).build()
        ).build();
    }
}
