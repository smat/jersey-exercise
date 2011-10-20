package no.bekk.java.jersey.exercise.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.bekk.java.jersey.exercise.dto.RootDto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/")
@Component
@Scope("prototype")
@Produces({ "application/xml", "application/json" })
public class RootResource {

	@GET
	public Response entrypoint() {
		return Response.ok(new RootDto()).build();
	}
}
