package no.bekk.java.jersey.exercise.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import no.bekk.java.jersey.exercise.dto.AnsattDto;
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
	public Response list() {
		List<AnsattDto> ansatte = ansattService.getAll();
		return Response.ok(ansatte).build();
	}

	@POST
	public Response addNew(final AnsattDto ansattDto) {
		AnsattDto insertedAnsatt = ansattService.insert(ansattDto);
		URI uri = UriBuilder.fromResource(getClass()).build(insertedAnsatt.getId());
		return Response.created(uri).entity(insertedAnsatt).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final long id) {
		return Response.ok(ansattService.getById(id)).build();
	}
}
