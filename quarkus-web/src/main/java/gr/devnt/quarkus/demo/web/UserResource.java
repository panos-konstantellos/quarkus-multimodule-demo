package gr.devnt.quarkus.demo.web;

import gr.devnt.quarkus.demo.data.UserService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/users")
@AllArgsConstructor
public class UserResource {
    private final UserService userService;

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") String id) {
        var user = userService.get(id);

        if (user.isEmpty()) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(user.get())
                .build();
    }
}
