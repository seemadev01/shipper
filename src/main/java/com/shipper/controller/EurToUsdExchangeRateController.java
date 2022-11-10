package com.shipper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shipper.common.utils.RestResponse;
import com.shipper.common.utils.RestUtils;
import com.shipper.service.ExchangeRateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/exchangeRate")
@Api(value = "/exchangeRate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Exchange Rate API's" }, hidden = false)
@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 401, message = "Not Authorized"), @ApiResponse(code = 403, message = "Not Authenticated"),
		@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 500, message = "Internal Server Error") })
@Validated
public class EurToUsdExchangeRateController {
	
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@ApiOperation(value = "Exchange Rate", response = String.class, httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = Double.class) })
	@GetMapping(path = "/getExhangeRate")
	@ResponseBody
	public ResponseEntity<RestResponse<Double>> getExhangeRate() {
		return RestUtils.successResponse(exchangeRateService.getExchangeRate());
	}


}
