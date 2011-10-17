package no.bekk.java.jersey.exercise.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.bekk.java.jersey.exercise.service.AnsattService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/ansatt")
@Component
@Scope("prototype")
@Produces({ "application/xml", "application/json" })
public class AnsattResource {

	private final AnsattService ansattService;

	@Autowired
	public AnsattResource(final AnsattService ansattService) {
		this.ansattService = ansattService;
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final long id) {
		return Response.ok(ansattService.getById(id)).build();
	}
}
