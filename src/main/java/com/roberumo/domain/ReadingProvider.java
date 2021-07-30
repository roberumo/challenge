package com.roberumo.domain;

import java.util.List;

/**
 * Interface
 *
 * @author rruiz on 2021-07-27
 */
public interface ReadingProvider {

	List<Reading> provide(String file);

}
