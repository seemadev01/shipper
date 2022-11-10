package com.shipper.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.shipper.common.utils.Logger;
import com.shipper.common.utils.RestTemplateHelper;
import com.shipper.common.utils.Utils;
import com.shipper.dto.EurToUsdExchangeRateResponseDto;

@Service
public class ExchangeRateService {

	@Autowired
	private RestTemplateHelper restTemplateHelper;

	@Value("${shipper.get.exchangeRate}")
	private String exchangeRateFetchUrl;

	private Logger log = Logger.getLogger(getClass());

	public Double getExchangeRate() {

		EurToUsdExchangeRateResponseDto responseEntity = null;

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("ContentType", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		try {
			responseEntity = restTemplateHelper.postForEntity(EurToUsdExchangeRateResponseDto.class,
					exchangeRateFetchUrl, null);
			log.info("Eur To Usd Exchange Rate Response{} ", Utils.toJsonString(responseEntity));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (java.util.Objects.nonNull(responseEntity))
			return responseEntity.getUsd().getRate();
		else
			throw new EntityNotFoundException("Rate not found");

	}

}
