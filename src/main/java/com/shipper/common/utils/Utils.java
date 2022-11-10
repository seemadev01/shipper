package com.shipper.common.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class Utils.
 */
public class Utils {

	private Utils() {
		super();
	}

	public static boolean checkCollectionIsNotEmpty(Collection<?> collection) {
		return Boolean.FALSE.equals(CollectionUtils.isEmpty(collection));
	}

	public static boolean checkCollectionIsNotEmpty(Map<?, ?> collection) {
		return Boolean.FALSE.equals(CollectionUtils.isEmpty(collection));
	}

	public static boolean checkCollectionIsEmpty(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}

	public static boolean checkCollectionIsEmpty(Map<?, ?> collection) {
		return CollectionUtils.isEmpty(collection);
	}

	public static List<Date> getMinMaxDate(Date date) {
		return Arrays.asList(
				new DateTime(date).hourOfDay().withMinimumValue().minuteOfHour().withMinimumValue().secondOfMinute()
						.withMinimumValue().millisOfSecond().withMinimumValue().toDate(),
				new DateTime(date).hourOfDay().withMaximumValue().minuteOfHour().withMaximumValue().secondOfMinute()
						.withMaximumValue().millisOfSecond().withMaximumValue().toDate());
	}
	
	public static DateTime getMinDate(Date date) {
		return new DateTime(date).hourOfDay().withMinimumValue().minuteOfHour().withMinimumValue().secondOfMinute()
				.withMinimumValue().millisOfSecond().withMinimumValue();
	}

	public static String toJsonString(Object... objects) {
		ObjectMapper mapperObj = new ObjectMapper();
		try {
			return mapperObj.writeValueAsString(objects);
		} catch (Exception e) {
			Logger.getLogger(Utils.class).error(e.getLocalizedMessage(), e);
		}
		return "";
	}

}
