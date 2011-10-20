package no.bekk.java.jersey.exercise.dto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sun.jersey.server.linking.Ref;
import com.sun.jersey.server.linking.Ref.Style;

@XmlRootElement(name = "ansattList")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("restriction")
public class AnsattListDto {
	@XmlElement(name = "ansatt")
	@JsonProperty("ansatte")
	public List<AnsattDto> ansatt = new ArrayList<AnsattDto>();

	@Ref(value = "ansatt", style = Style.ABSOLUTE)
	public URI self;
}
