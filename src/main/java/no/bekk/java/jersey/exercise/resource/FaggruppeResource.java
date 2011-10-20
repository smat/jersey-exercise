package no.bekk.java.jersey.exercise.resource;

import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.service.FaggruppeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/faggruppe")
@Component
@Scope("prototype")
@Produces({ "application/xml", "application/json" })
public class FaggruppeResource {

    private FaggruppeService faggruppeService;

    @Autowired
    public FaggruppeResource(FaggruppeService faggruppeService) {
        this.faggruppeService = faggruppeService;
    }

    @GET
    public Response list() {
        return Response.ok(faggruppeService.getAll()).build();
    }

    @POST
    public Response addNew(FaggruppeDto faggruppe) {
        FaggruppeDto insertedFaggruppe = faggruppeService.insert(faggruppe);
        URI uri = UriBuilder.fromPath("{id}").build(insertedFaggruppe.id);
        return Response.created(uri).entity(insertedFaggruppe).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") long id) {
        try {
            return Response.ok(faggruppeService.getById(id)).build();
        } catch (EmptyResultDataAccessException e) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        boolean deleted = faggruppeService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        }
    }
}
