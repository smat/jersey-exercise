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

	public AnsattDto insert(final AnsattDto ansattDto) {
		Ansatt ansatt = new Ansatt(ansattDto);
		return new AnsattDto(ansattDao.insert(ansatt));
	}

	public AnsattDto getById(final long id) {
		try {
			return new AnsattDto(ansattDao.getById(id));
		} catch (EmptyResultDataAccessException e) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}
	}

	public boolean deleteById(final long id) {
		return ansattDao.deleteById(id);
	}

    public boolean updateFaggruppeId(long ansattId, long faggruppeId) {
        return ansattDao.updateFaggruppe(ansattId, faggruppeId);
    }
    
	public AnsattListDto getAll() {
		AnsattListDto list = new AnsattListDto();
		for (Ansatt ansatt : ansattDao.list()) {
			list.ansatt.add(new AnsattDto(ansatt));
		}
		return list;
	}

}
