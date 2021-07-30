package com.roberumo.domain;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public final class SuspiciousReading {

	private final ClientID clientID;
	private final Period period;
	private final float readingValue;
	private final float median;

	public SuspiciousReading(final ClientID clientID, final Period period, final float readingValue, final float median) {
		this.clientID = clientID;
		this.period = period;
		this.readingValue = readingValue;
		this.median = median;
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

	public float getMedian() {
		return this.median;
	}
}
