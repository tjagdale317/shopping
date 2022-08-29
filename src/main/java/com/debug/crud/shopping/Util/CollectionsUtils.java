package com.debug.crud.shopping.Util;

import java.util.Collection;

public final class CollectionsUtils {

	private CollectionsUtils() {
	}

	public static boolean isEmpty(Collection<?> object) {
		if (object.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(Collection<?> object) {
		return isEmpty(object);
	}

}
