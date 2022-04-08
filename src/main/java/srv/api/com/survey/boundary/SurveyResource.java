package srv.api.com.survey.boundary;

import org.jboss.logging.Logger;
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

/**
 * The Survey resource
 * Used for handling HTTP requests
 */
@Path("survey")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class SurveyResource {

    private static final Logger log = Logger.getLogger(SurveyResource.class);

    @Inject
    SurveyService surveyService;

    /**
     * Gets a paginated list of Surveys that fulfill the given search parameters
     *
     * @param page number of the page list
     * @param size size of the page list
     * @return Response 200 containing List of GetAllSurveyDTO
     */
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

    /**
     * Gets a Survey by its ID
     *
     * @param surveyID Survey's ID
     * @return Response 200 containing the GetSurveyDTO / 404 if ParkingPoint is not found
     */
    @GET
    @Path("{SurveyID}")
    public Response getByID(@PathParam("SurveyID") SurveyID surveyID) {
        log.info("getByID() => Finding survey point by ID");

        return Response.ok(
                GetSurveyDTO.createDTOFromSurvey(surveyService.getByID(surveyID))
        ).build();
    }

    /**
     * Creates a new survey
     *
     * @param createSurveyDTO the CreateSurveyDTO that is created
     * @return Response 201 with location in header
     */
    @POST
    public Response createSurvey(@Valid CreateSurveyDTO createSurveyDTO, @Context UriInfo uriInfo) {
        log.info("create => Creating a new Survey");

        Survey survey = surveyService.create(createSurveyDTO.createSurveyFromDTO());
        if (surveyService.checkSurvey(survey.getSurveyID()))
            return Response.status(409).entity("Survey already exists.").build();

        return Response.created(uriInfo.getRequestUriBuilder()
            .path(
                    survey.getSurveyID().getUUID().toString()
            ).build()
        ).build();
    }


}
