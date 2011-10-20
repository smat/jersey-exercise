package no.bekk.java.jersey.exercise.dto;

import com.sun.jersey.server.linking.Ref;
import no.bekk.java.jersey.exercise.model.Faggruppe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.net.URI;

@XmlRootElement(name = "Faggruppe")
@XmlAccessorType(XmlAccessType.FIELD)
public class FaggruppeDto {
    public Long id;
    public Long faggruppesjefId;
    public String navn;

    @Ref(value = "faggruppe/{id}", style = Ref.Style.ABSOLUTE)
	public URI link;

    @Ref(value = "ansatt/{faggruppesjefId}", style = Ref.Style.ABSOLUTE)
	public URI faggruppesjef;

    public FaggruppeDto() {
    }

    public FaggruppeDto(Faggruppe faggruppe) {
        id = faggruppe.getId();
        navn = faggruppe.getNavn();
        faggruppesjefId = faggruppe.getFagruppesjefId();
    }

    public Long getId() {
        return id;
    }

    public Long getFaggruppesjefId() {
        return faggruppesjefId;
    }
}
