package no.bekk.java.jersey.exercise.service;

import no.bekk.java.jersey.exercise.dao.FaggruppeDao;
import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.dto.FaggruppeListDto;
import no.bekk.java.jersey.exercise.model.Faggruppe;

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

	public boolean slett(final long id) {
		return faggruppeDao.deleteById(id);
	}
}
