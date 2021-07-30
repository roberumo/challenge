package com.roberumo.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public class ReadingObjectMother {

	public static List<Reading> existingReadings(){

		final Reading reading1 = new Reading(new ClientID("aaa"), new Period("2020-08"), 500f);
		final Reading reading2 = new Reading(new ClientID("bb"), new Period("2020-09"), 500f);

		return Arrays.asList(reading1, reading2);
	}

	public static List<Reading> oneReading(){

		final Reading reading1 = new Reading(new ClientID("aaa"), new Period("2020-08"), 500f);

		return Collections.singletonList(reading1);
	}
}
