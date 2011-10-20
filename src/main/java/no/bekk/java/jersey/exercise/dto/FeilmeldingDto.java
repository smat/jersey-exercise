package no.bekk.java.jersey.exercise.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Feilmelding")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class FeilmeldingDto {

	public Feilkode feilkode;

	public FeilmeldingDto(final Feilkode feilkode) {
		this.feilkode = feilkode;
	}

	public String getFeilkode() {
		return feilkode.name();
	}

	public String getFeilmelding() {
		return feilkode.getFeilmelding();
	}

}
