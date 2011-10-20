package no.bekk.java.jersey.exercise.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.bekk.java.jersey.exercise.dao.FaggruppeDao;
import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.dto.FaggruppeListDto;
import no.bekk.java.jersey.exercise.dto.FeilmeldingDto;
import no.bekk.java.jersey.exercise.model.Faggruppe;
import no.bekk.java.jersey.exercise.model.Feilkode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaggruppeService {

	private final FaggruppeDao faggruppeDao;

	@Autowired
	public FaggruppeService(final FaggruppeDao faggruppeDao) {
		this.faggruppeDao = faggruppeDao;
	}

	public FaggruppeDto hent(final long ansattId) {
		return new FaggruppeDto(faggruppeDao.getById(ansattId));
	}

	public FaggruppeDto opprettNy(final FaggruppeDto faggruppeDto) {
		return new FaggruppeDto(faggruppeDao.insert(new Faggruppe(faggruppeDto)));
	}

	public FaggruppeListDto hentAlle() {
		FaggruppeListDto list = new FaggruppeListDto();
		for (Faggruppe faggruppe : faggruppeDao.list()) {
			list.faggruppe.add(new FaggruppeDto(faggruppe));
		}
		return list;
	}

	public void slett(final long id) {
		boolean deleted = faggruppeDao.deleteById(id);
		if (!deleted) {
			throw new WebApplicationException(Response
					.status(Status.NOT_FOUND)
					.entity(new FeilmeldingDto(Feilkode.SLETTING_FEILET))
					.build());
		}
	}
}
