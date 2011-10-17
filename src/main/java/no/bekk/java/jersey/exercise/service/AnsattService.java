package no.bekk.java.jersey.exercise.service;

import no.bekk.java.jersey.exercise.dao.AnsattDao;
import no.bekk.java.jersey.exercise.dto.AnsattDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnsattService {

	private final AnsattDao ansattDao;

	@Autowired
	public AnsattService(final AnsattDao ansattDao) {
		this.ansattDao = ansattDao;
	}

	public AnsattDto getById(final long id) {
		return new AnsattDto(ansattDao.getById(id));
	}

}
