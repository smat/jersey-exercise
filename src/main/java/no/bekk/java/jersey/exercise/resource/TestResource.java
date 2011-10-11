package no.bekk.java.jersey.exercise.resource;

import no.bekk.java.jersey.exercise.dto.TestDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/test")
@Component
@Scope("prototype")
@Produces({"application/xml", "application/json"})
public class TestResource {
    @GET
    public Response test() {
        return Response.ok(new TestDto("Test")).build();
    }
}
