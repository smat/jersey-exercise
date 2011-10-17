package no.bekk.java.jersey.exercise.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.bekk.java.jersey.exercise.model.Ansatt;

@XmlRootElement(name = "Ansatt")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnsattDto {
	public String fornavn;
	public String etternavn;

	public AnsattDto() {

	}

	public AnsattDto(final Ansatt ansatt) {
		fornavn = ansatt.getFornavn();
		etternavn = ansatt.getEtternavn();
	}
}
