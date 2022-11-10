package com.shipper.dto;

import java.io.Serializable;

public class EurToUsdExchangeRateResponseDto implements Serializable {

	private static final long serialVersionUID = -3364568471137012429L;
	private Usd usd;

	public Usd getUsd() {
		return usd;
	}

	public void setUsd(Usd usd) {
		this.usd = usd;
	}

	@Override
	public String toString() {
		return "EurToUsdExchangeRateResponseDto [usd=" + usd + "]";
	}

}
