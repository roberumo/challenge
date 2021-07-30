package com.roberumo.domain;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public final class Reading implements Comparable<Reading> {

	private final ClientID clientID;
	private final Period period;
	private final Float readingValue;

	public Reading(final ClientID clientID, final Period period, final float readingValue) {
		this.clientID = clientID;
		this.period = period;
		this.readingValue = readingValue;
	}

	public ClientID getClientID() {
		return this.clientID;
	}

	public Period getPeriod() {
		return this.period;
	}

	public float getReadingValue() {
		return this.readingValue;
	}

	@Override
	public int compareTo(final Reading reading) {
		return this.readingValue.compareTo(reading.readingValue);
	}
}
