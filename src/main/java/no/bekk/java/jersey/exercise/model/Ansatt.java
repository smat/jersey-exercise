package no.bekk.java.jersey.exercise.model;

import no.bekk.java.jersey.exercise.dto.AnsattDto;

public class Ansatt {
	Long id;
	String fornavn;
	String etternavn;

	public Ansatt(final AnsattDto ansattDto) {
		fornavn = ansattDto.fornavn;
		etternavn = ansattDto.etternavn;
	}

	public Ansatt() {
		// TODO Auto-generated constructor stub
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

}
