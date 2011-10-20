package no.bekk.java.jersey.exercise.model;

import no.bekk.java.jersey.exercise.dto.AnsattDto;

public class Ansatt {
	long id;
	String fornavn;
	String etternavn;
	long faggruppeId;

	public Ansatt(final AnsattDto ansattDto) {
		fornavn = ansattDto.fornavn;
		etternavn = ansattDto.etternavn;
		faggruppeId = ansattDto.faggruppeId;
	}

	public Ansatt() {

	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
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

	public long getFaggruppeId() {
		return faggruppeId;
	}

	public void setFaggruppeId(final long faggruppeId) {
		this.faggruppeId = faggruppeId;
	}
}
