package no.bekk.java.jersey.exercise.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestDto {
    public String message;

    public TestDto() {
    }

    public TestDto(String message) {
        this.message = message;
    }
}
