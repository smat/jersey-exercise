package no.bekk.java.jersey.exercise.model;

import no.bekk.java.jersey.exercise.dto.FaggruppeDto;

public class Faggruppe {
	private long id;
	private String navn;
	private long fagruppesjefId;

	public Faggruppe() {
	}

	public Faggruppe(final FaggruppeDto faggruppeDto) {
		navn = faggruppeDto.navn;
		fagruppesjefId = faggruppeDto.faggruppesjefId;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(final String navn) {
		this.navn = navn;
	}

	public long getFagruppesjefId() {
		return fagruppesjefId;
	}

	public void setFagruppesjefId(final long fagruppesjefId) {
		this.fagruppesjefId = fagruppesjefId;
	}
}
