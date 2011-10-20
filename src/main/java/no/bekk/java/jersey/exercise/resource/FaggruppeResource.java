package no.bekk.java.jersey.exercise.resource;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.service.FaggruppeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/faggruppe")
@Component
@Scope("prototype")
@Produces({ "application/xml", "application/json" })
public class FaggruppeResource {

	private final FaggruppeService faggruppeService;

	@Autowired
	public FaggruppeResource(final FaggruppeService faggruppeService) {
		this.faggruppeService = faggruppeService;
	}

	@GET
	public Response list() {
		return Response.ok(faggruppeService.hentAlle()).build();
	}

	@POST
	public Response addNew(final FaggruppeDto faggruppe) {
		FaggruppeDto insertedFaggruppe = faggruppeService.opprettNy(faggruppe);
		URI uri = UriBuilder.fromPath("{id}").build(insertedFaggruppe.getId());
		return Response.created(uri).entity(insertedFaggruppe).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final long id) {
		return Response.ok(faggruppeService.hent(id)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") final long id) {
		faggruppeService.slett(id);
		return Response.noContent().build();
	}
}
