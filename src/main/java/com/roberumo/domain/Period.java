package com.roberumo.domain;

import java.util.Objects;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public final class Period {

	private final String value;

	public Period(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		final Period period = (Period) o;
		return Objects.equals(this.value, period.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}
}
