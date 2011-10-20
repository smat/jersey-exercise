package no.bekk.java.jersey.exercise.dto;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.server.linking.Ref;
import com.sun.jersey.server.linking.Ref.Style;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class RootDto {

	@Ref(value = "ansatt", style = Style.ABSOLUTE)
	public URI ansattLink;

	@Ref(value = "faggruppe", style = Style.ABSOLUTE)
	public URI faggruppeLink;

}
