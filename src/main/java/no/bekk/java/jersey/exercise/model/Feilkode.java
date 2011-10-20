package no.bekk.java.jersey.exercise.model;

public enum Feilkode {
	SLETTING_FEILET("Kunne ikke slette ressursen");

	private final String feilmelding;

	Feilkode(final String feilmelding) {
		this.feilmelding = feilmelding;
	}

	public String getFeilmelding() {
		return feilmelding;
	}
}
