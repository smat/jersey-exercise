package no.bekk.java.jersey.exercise.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.bekk.java.jersey.exercise.dao.AnsattDao;
import no.bekk.java.jersey.exercise.dto.AnsattDto;
import no.bekk.java.jersey.exercise.dto.AnsattListDto;
import no.bekk.java.jersey.exercise.model.Ansatt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AnsattService {

	private final AnsattDao ansattDao;

	@Autowired
	public AnsattService(final AnsattDao ansattDao) {
		this.ansattDao = ansattDao;
	}

	public AnsattDto opprettNy(final AnsattDto ansattDto) {
		Ansatt ansatt = new Ansatt(ansattDto);
		return new AnsattDto(ansattDao.insert(ansatt));
	}

	public AnsattDto hent(final long ansattId) {
		try {
			return new AnsattDto(ansattDao.getById(ansattId));
		} catch (EmptyResultDataAccessException e) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}
	}

	public boolean slett(final long ansattId) {
		return ansattDao.deleteById(ansattId);
	}

	public boolean oppdaterFaggruppe(final long ansattId, final long faggruppeId) {
		return ansattDao.updateFaggruppe(ansattId, faggruppeId);
	}

	public AnsattListDto hentAlle() {
		AnsattListDto list = new AnsattListDto();
		for (Ansatt ansatt : ansattDao.list()) {
			list.ansatt.add(new AnsattDto(ansatt));
		}
		return list;
	}

}
