package srv.api.com.user.boundary;

import io.quarkus.security.identity.SecurityIdentity;
import srv.api.com.user.model.UserInfo;
import srv.api.com.user.model.UserInfoID;
import srv.api.com.user.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    SecurityIdentity identity;

    @Inject
    UserService userService;

    @GET
    @RolesAllowed("admin")
    @PathParam("{userID}")
    public Response getById(@PathParam("userID") UserInfoID userInfoID) {
        UserInfo userInfo = userService.getByID(userInfoID);
        return Response.ok(userInfo).build();
    }

    @GET
    @RolesAllowed("admin")
    public Response getByKeyCloakID() {
        return Response.ok().build();
    }

    @POST
    public Response create() {
        return Response.ok().build();
    }

    @PUT
    @RolesAllowed("admin")
    public Response update() {
        return Response.ok().build();
    }

    @DELETE
    @RolesAllowed("admin")
    public Response delete() {
        return Response.ok().build();
    }

}
