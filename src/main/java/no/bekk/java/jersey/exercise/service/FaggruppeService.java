package no.bekk.java.jersey.exercise.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.bekk.java.jersey.exercise.dao.FaggruppeDao;
import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.dto.FaggruppeListDto;
import no.bekk.java.jersey.exercise.model.Faggruppe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FaggruppeService {

	private final FaggruppeDao faggruppeDao;

	@Autowired
	public FaggruppeService(final FaggruppeDao faggruppeDao) {
		this.faggruppeDao = faggruppeDao;
	}

	public FaggruppeDto getById(final long id) {
		try {
			return new FaggruppeDto(faggruppeDao.getById(id));
		} catch (EmptyResultDataAccessException e) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}
	}

	public FaggruppeDto insert(final FaggruppeDto faggruppeDto) {
		return new FaggruppeDto(faggruppeDao.insert(new Faggruppe(faggruppeDto)));
	}

	public FaggruppeListDto getAll() {
		FaggruppeListDto list = new FaggruppeListDto();
		for (Faggruppe faggruppe : faggruppeDao.list()) {
			list.faggruppe.add(new FaggruppeDto(faggruppe));
		}
		return list;
	}

	public boolean delete(final long id) {
		return faggruppeDao.delete(id);
	}
}
