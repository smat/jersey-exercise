package no.bekk.java.jersey.exercise.service;

import no.bekk.java.jersey.exercise.dao.FaggruppeDao;
import no.bekk.java.jersey.exercise.dto.FaggruppeDto;
import no.bekk.java.jersey.exercise.dto.FaggruppeListDto;
import no.bekk.java.jersey.exercise.model.Faggruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaggruppeService {

    private FaggruppeDao faggruppeDao;

    @Autowired
    public FaggruppeService(FaggruppeDao faggruppeDao) {
        this.faggruppeDao = faggruppeDao;
    }

    public FaggruppeDto getById(long id) {
        return new FaggruppeDto(faggruppeDao.getById(id));
    }

    public FaggruppeDto insert(FaggruppeDto faggruppeDto) {
        return new FaggruppeDto(faggruppeDao.insert(new Faggruppe(faggruppeDto)));
    }

    public FaggruppeListDto getAll() {
        FaggruppeListDto list = new FaggruppeListDto();
        for (Faggruppe faggruppe : faggruppeDao.list()) {
            list.faggruppe.add(new FaggruppeDto(faggruppe));
        }
        return list;
    }

    public boolean delete(long id) {
        return faggruppeDao.delete(id);
    }
}
