package com.roberumo.domain;

import java.util.Objects;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public final class ClientID {

	private final String value;

	public ClientID(final String value) {
		// aqui irian validaciones en tiempo de construccion
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		final ClientID clientID = (ClientID) o;
		return Objects.equals(this.value, clientID.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}
}
