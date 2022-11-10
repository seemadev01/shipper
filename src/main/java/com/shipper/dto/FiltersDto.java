package com.shipper.dto;

import java.io.Serializable;
import java.util.Date;
import com.shipper.enums.FilterKeys;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * The Class FiltersDto.
 */
public class FiltersDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3323456459925167876L;

	/** The key. */
	private FilterKeys key;

	/** The value. */
	private String value;

	/** The date value. */
	private Date dateValue;

	public FiltersDto() {
		super();
	}

	public FiltersDto(FilterKeys key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public FilterKeys getKey() {
		return key;
	}

	public void setKey(FilterKeys key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	@Override
	public String toString() {
		return "FiltersDto [key=" + key + ", value=" + value + ", dateValue=" + dateValue + "]";
	}

}
