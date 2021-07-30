package com.roberumo.application;

import com.roberumo.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

class SuspiciousReadingDetectorTest {

	@Mock
	private ReadingProvider mockedReadingProvider;

	@Mock
	private ReadingOutputter mockedReadingOutputter;

	@InjectMocks
	private SuspiciousReadingDetector detector;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testNoSuspiciousReadings() {
		// Given
		final List<SuspiciousReading> suspiciousReadings = SuspiciousReadingObjectMother.anySuspiciousReading();
		final List<Reading> readings = ReadingObjectMother.existingReadings();

		final String inputFile = "file.xml";

		Mockito.doReturn(readings).when(this.mockedReadingProvider).provide(inputFile);

		// When
		this.detector.detect(inputFile);

		// Then
		Mockito.verify(this.mockedReadingOutputter).output(suspiciousReadings);
	}

	@Test
	void testOneReading() {
		// Given
		final List<SuspiciousReading> suspiciousReadings = SuspiciousReadingObjectMother.anySuspiciousReading();
		final List<Reading> readings = ReadingObjectMother.oneReading();

		final String inputFile = "file.xml";

		Mockito.doReturn(readings).when(this.mockedReadingProvider).provide(inputFile);

		// When
		this.detector.detect(inputFile);

		// Then
		Mockito.verify(this.mockedReadingOutputter).output(suspiciousReadings);
	}

	//TODO: more deterministic tests
}