package srv.api.com.test;

import com.sun.istack.NotNull;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("test")
@RequestScoped
@Transactional
public class TestResource {

    @Inject
    TestRepository testRepository;

    @POST
    public Response saveTest(@NotNull TestModel testModel, @Context UriInfo uriInfo) {
        testRepository.save(testModel);

        return Response.created(uriInfo.getRequestUriBuilder().path(testModel.getEntityId().toString()).build()).build();
    }
}
