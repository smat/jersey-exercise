package no.bekk.java.jersey.exercise.dto;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.bekk.java.jersey.exercise.model.Ansatt;

import com.sun.jersey.server.linking.Ref;
import com.sun.jersey.server.linking.Ref.Style;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Ansatt")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class AnsattDto {
	private long id;
	public String fornavn;
	public String etternavn;
	public long faggruppeId;

	@Ref(value = "ansatt/{id}", style = Style.ABSOLUTE)
	public URI self;

	@Ref(value = "faggruppe/{faggruppeId}", style = Style.ABSOLUTE)
	public URI faggruppe;

	public AnsattDto() {

	}

	public AnsattDto(final Ansatt ansatt) {
		id = ansatt.getId();
		fornavn = ansatt.getFornavn();
		etternavn = ansatt.getEtternavn();
		faggruppeId = ansatt.getFaggruppeId();
	}

	public long getId() {
		return id;
	}

	public long getFaggruppeId() {
		return faggruppeId;
	}
}
