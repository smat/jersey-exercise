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

@XmlRootElement(name = "faggruppeList")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("restriction")
public class FaggruppeListDto {
	@XmlElement(name = "faggruppe")
	@JsonProperty("faggrupper")
	public List<FaggruppeDto> faggruppe = new ArrayList<FaggruppeDto>();

	@Ref(value = "faggruppe", style = Style.ABSOLUTE)
	public URI self;
}
