package no.bekk.java.jersey.exercise.dto;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import no.bekk.java.jersey.exercise.model.Faggruppe;

import com.sun.jersey.server.linking.Ref;
import com.sun.jersey.server.linking.Ref.Style;

@XmlRootElement(name = "Faggruppe")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("restriction")
public class FaggruppeDto {
	public long id;
	public long faggruppesjefId;
	public String navn;

	@Ref(value = "faggruppe/{id}", style = Style.ABSOLUTE)
	public URI self;

	@Ref(value = "ansatt/{faggruppesjefId}", style = Style.ABSOLUTE)
	public URI faggruppesjef;

	public FaggruppeDto() {
	}

	public FaggruppeDto(final Faggruppe faggruppe) {
		id = faggruppe.getId();
		navn = faggruppe.getNavn();
		faggruppesjefId = faggruppe.getFagruppesjefId();
	}

	public long getId() {
		return id;
	}

	public long getFaggruppesjefId() {
		return faggruppesjefId;
	}
}
