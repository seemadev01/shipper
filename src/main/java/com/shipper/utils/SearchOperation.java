/*
 * @author Advatix
 * 
 * @since 2019
 * 
 * @version 1.0
 */
package com.shipper.utils;

/**
 * The Enum SearchOperation.
 */
public enum SearchOperation {

	/** The equality. */
	EQUALITY,
	/** The negation. */
	NEGATION,
	/** The greater than. */
	GREATER_THAN,
	/** The less than. */
	LESS_THAN,
	/** The greater than or equals. */
	GREATER_THAN_EQUALS, GREATER_THAN_EQUALS_INT, DATE_GREATER_THAN, DATE_GREATER_THAN_EQUALS,
	/** The less than or equals. */
	LESS_THAN_EQUAL, DATE_LESS_THAN, DATE_LESS_THAN_EQUAL,
	/** The like. */
	LIKE,
	/** The starts with. */
	STARTS_WITH,
	/** The ends with. */
	ENDS_WITH,
	/** The contains. */
	CONTAINS,
	/** The longin. */
	LONGIN,
	/** The stringin. */
	STRINGIN,
	/** The integerin. */
	INTEGERIN,
	/** The not null. */
	NOT_NULL, IS_NULL, JOIN_MULTI_INTEGER_LIST, JOIN_MULTI_LONG_LIST, JOIN_MULTI_STRING_LIST, JOIN_MULTI_STRING,
	JOIN_MULTI_INTEGER_LIST_IN, JOIN_MULTI_INTEGER_LIST_NOT_IN, JOIN_MULTI_LONG_LIST_IN, JOIN_MULTI_INTEGER_LIST_NOT_EQ,
	JOIN_MULTI_STRING_IN, JOIN_MULTI_STRING_NOT_IN, JOIN_MULTI_DATE_GREATER_THAN, JOIN_MULTI_DATE_LESS_THAN,
	STRING_NOT_IN, GROUP_BY, STRING_NOT_IN_MULTI_JOIN,JOIN_MULTI_STRING_LIST_NOT_EQ,
	JOIN_MULTI_STRING_LIST_CONTAINS;
}
