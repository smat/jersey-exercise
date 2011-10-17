package no.bekk.java.jersey.exercise.model;

import no.bekk.java.jersey.exercise.dto.FaggruppeDto;

public class Faggruppe {
    private Long id;
    private String navn;
    private Long fagruppesjefId;

    public Faggruppe() {
    }

    public Faggruppe(FaggruppeDto faggruppeDto) {
        navn = faggruppeDto.navn;
        fagruppesjefId = faggruppeDto.faggruppesjefId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Long getFagruppesjefId() {
        return fagruppesjefId;
    }

    public void setFagruppesjefId(Long fagruppesjefId) {
        this.fagruppesjefId = fagruppesjefId;
    }
}
