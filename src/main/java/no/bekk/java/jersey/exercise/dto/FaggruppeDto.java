package no.bekk.java.jersey.exercise.dto;

import no.bekk.java.jersey.exercise.model.Faggruppe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Faggruppe")
@XmlAccessorType(XmlAccessType.FIELD)
public class FaggruppeDto {

    @XmlTransient
    public Long id;
    public Long faggruppesjefId;
    public String navn;

    public FaggruppeDto() {
    }

    public FaggruppeDto(Faggruppe faggruppe) {
        id = faggruppe.getId();
        navn = faggruppe.getNavn();
        faggruppesjefId = faggruppe.getFagruppesjefId();
    }
}
