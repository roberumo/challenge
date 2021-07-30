package com.roberumo.application;

import com.roberumo.domain.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class
 *
 * @author rruiz on 2021-07-27
 */

public class SuspiciousReadingDetector {

	private static final int DEFAULT_CHUNK_SIZE = 12; // esta constante se podria inyectar desde fuera

	private final ReadingProvider readingProvider;
	private final ReadingOutputter readingOutputter;

	public SuspiciousReadingDetector(final ReadingProvider readingProvider, final ReadingOutputter readingOutputter) {
		this.readingProvider = readingProvider;
		this.readingOutputter = readingOutputter;
	}

	public void detect(final String inputSource) {
		// obtener lecturas
		final List<Reading> readings = this.readingProvider.provide(inputSource);

		// calculo (la parte de calculo del algoritmo se podria sacar a un servicio a parte)
		final Map<ClientID, Float> mediansByClient = new HashMap<>();
		for (int i = 0; i < readings.size(); i += SuspiciousReadingDetector.DEFAULT_CHUNK_SIZE) {
			mediansByClient.put(
					readings.get(i).getClientID(),
					SuspiciousReadingDetector.calculateMedian(readings.subList(i, SuspiciousReadingDetector.DEFAULT_CHUNK_SIZE))
			);
		}

		final List<SuspiciousReading> suspiciousReadings = readings.stream()
				.filter(reading -> isSuspicious(reading, mediansByClient.get(reading.getClientID()), 50f))
				.map(reading -> new SuspiciousReading(reading.getClientID(), reading.getPeriod(), reading.getReadingValue(), mediansByClient.get(reading.getClientID())))
				.collect(Collectors.toList());

		// sacar resultados
		this.readingOutputter.output(suspiciousReadings);
	}

	private static Float calculateMedian(final List<Reading> readings) {
		Collections.sort(readings);

		if (readings.size() % 2 == 0) {
			final Reading reading1 = readings.get(readings.size() / 2);
			final Reading reading2 = readings.get(readings.size() / 2 - 1);

			return (reading1.getReadingValue() + reading2.getReadingValue()) / 2;
		} else {
			return readings.get(readings.size() / 2).getReadingValue();
		}
	}

	private boolean isSuspicious(Reading reading, Float median, float thresholdPercentage) { //este metodo se podria mover a la clase Reading
		return true;
	}
}

