package no.bekk.java.jersey.exercise.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ansattList")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnsattListDto {
    @XmlElement(name = "ansatt")
    @JsonProperty("ansatte")
    public List<AnsattDto> ansatt = new ArrayList<AnsattDto>();
}
