package no.bekk.java.jersey.exercise.resource;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

	// TODO: alle metoder :)
}
