package no.bekk.java.jersey.exercise.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.bekk.java.jersey.exercise.model.Ansatt;

@XmlRootElement(name = "Ansatt")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AnsattDto {
	private long id;
	public String fornavn;
	public String etternavn;

	public AnsattDto() {

	}

	public AnsattDto(final Ansatt ansatt) {
		id = ansatt.getId();
		fornavn = ansatt.getFornavn();
		etternavn = ansatt.getEtternavn();
	}

	public long getId() {
		return id;
	}
}
