package com.shipper.dto;

import java.io.Serializable;

public class Usd implements Serializable{
	
	private static final long serialVersionUID = 3149608781895221599L;
	private String code;
	private String alphaCode;
	private String numericCode;
	private String name;
	private double rate;
	private String date;
	private double inverseRate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAlphaCode() {
		return alphaCode;
	}
	public void setAlphaCode(String alphaCode) {
		this.alphaCode = alphaCode;
	}
	public String getNumericCode() {
		return numericCode;
	}
	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getInverseRate() {
		return inverseRate;
	}
	public void setInverseRate(double inverseRate) {
		this.inverseRate = inverseRate;
	}
	@Override
	public String toString() {
		return "Usd [code=" + code + ", alphaCode=" + alphaCode + ", numericCode=" + numericCode + ", name=" + name
				+ ", rate=" + rate + ", date=" + date + ", inverseRate=" + inverseRate + "]";
	}
	
}
