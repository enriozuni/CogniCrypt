/********************************************************************************
 * Copyright (c) 2015-2018 TU Darmstadt This program and the accompanying materials are made available under the terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0. SPDX-License-Identifier: EPL-2.0
 ********************************************************************************/

package de.cognicrypt.utils;

import java.util.AbstractMap.SimpleEntry;

public class ComparableEntry<K extends Comparable<?>, V extends Comparable<?>> extends SimpleEntry<K , V> implements Comparable<ComparableEntry<K, V>> {

	private static final long serialVersionUID = -7202623997902577640L;

	public ComparableEntry(final K key, final V value) {
		super(key, value);
	}

	@Override
	public int compareTo(final ComparableEntry<K, V> comp) {
		if (equals(comp)) {
			return 0;
		}

		@SuppressWarnings("unchecked")
		final Comparable<K> thisX = (Comparable<K>) getKey();
		return thisX.compareTo(comp.getKey());
	}

}
