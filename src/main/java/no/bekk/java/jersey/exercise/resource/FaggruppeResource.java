package no.bekk.java.jersey.exercise.resource;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.dto.Feilkode;
import no.bekk.java.jersey.exercise.dto.FeilmeldingDto;
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

	@POST
	public Response addNew(final FaggruppeDto faggruppe) {
		FaggruppeDto insertedFaggruppe = faggruppeService.insert(faggruppe);
		URI uri = UriBuilder.fromPath("{id}").build(insertedFaggruppe.id);
		return Response.created(uri).entity(insertedFaggruppe).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") final long id) {
		return Response.ok(faggruppeService.getById(id)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") final long id) {
		boolean deleted = faggruppeService.delete(id);
		if (!deleted) {
			return Response.status(Status.BAD_REQUEST).entity(new FeilmeldingDto(Feilkode.SLETTING_FEILET)).build();
		}
		return Response.noContent().build();
	}
}
