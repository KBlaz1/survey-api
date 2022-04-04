package srv.api.com.survey.boundary;

import srv.api.com.general.domain.model.PageRequest;
import srv.api.com.general.domain.model.Pagination;
import srv.api.com.survey.Service.SurveyService;
import srv.api.com.survey.domain.model.Survey;
import srv.api.com.survey.domain.model.SurveyID;
import srv.api.com.survey.dto.CreateSurveyDTO;
import srv.api.com.survey.dto.GetAllSurveysDTO;
import srv.api.com.survey.dto.GetSurveyDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.stream.Collectors;

@Path("survey")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class SurveyResource {

    @Inject
    SurveyService surveyService;


    @GET
    public Response getAll(@QueryParam("page") @Min(1) @DefaultValue("1") int page,
                           @QueryParam("size") @Min(1) @Max(1000) @DefaultValue("10") int size,
                           @Context UriInfo uriInfo) {

        //PageRequest pageRequest = PageRequest.create(page, size);
        //List<Survey> surveyList = surveyService.getAll(pageRequest);
        final long count = surveyService.count();

        return Response.ok(surveyService.getAll(PageRequest.create(page, size))
                .stream().map(GetAllSurveysDTO::createDTOFromSurvey)
                .collect(Collectors.toList()))
                .header("Pagination-totalElements", count)
                .header("Pagination-totalPages", Pagination.totalPages(size, count))
                .links(Pagination.paginationLinks(page, size, count, uriInfo))
                .build();
    }

    @GET
    @Path("{SurveyID}")
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
