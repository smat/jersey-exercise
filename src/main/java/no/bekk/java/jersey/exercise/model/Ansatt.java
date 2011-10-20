package no.bekk.java.jersey.exercise.model;

import no.bekk.java.jersey.exercise.dto.AnsattDto;

public class Ansatt {
	Long id;
	String fornavn;
	String etternavn;
    Long faggruppeId;

	public Ansatt(final AnsattDto ansattDto) {
		fornavn = ansattDto.fornavn;
		etternavn = ansattDto.etternavn;
        faggruppeId = ansattDto.faggruppeId;
	}

	public Ansatt() {

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(final String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(final String etternavn) {
		this.etternavn = etternavn;
	}

    public Long getFaggruppeId() {
        return faggruppeId;
    }

    public void setFaggruppeId(Long faggruppeId) {
        this.faggruppeId = faggruppeId;
    }
}
