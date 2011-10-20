package no.bekk.java.jersey.exercise.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "faggruppeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class FaggruppeListDto {
    @XmlElement(name = "faggruppe")
    @JsonProperty("faggrupper")
    public List<FaggruppeDto> faggruppe = new ArrayList<FaggruppeDto>();
}
