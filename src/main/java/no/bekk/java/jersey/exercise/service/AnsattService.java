package no.bekk.java.jersey.exercise.service;

import java.util.ArrayList;
import java.util.List;

import no.bekk.java.jersey.exercise.dao.AnsattDao;
import no.bekk.java.jersey.exercise.dto.AnsattDto;
import no.bekk.java.jersey.exercise.model.Ansatt;

import org.springframework.beans.factory.annotation.Autowired;
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
		return new AnsattDto(ansattDao.getById(id));
	}

	public boolean deleteById(final long id) {
		return ansattDao.deleteById(id);
	}

	public List<AnsattDto> getAll() {
		List<AnsattDto> ansatte = new ArrayList<AnsattDto>();
		for (Ansatt ansatt : ansattDao.list()) {
			ansatte.add(new AnsattDto(ansatt));
		}
		return ansatte;
	}

}
