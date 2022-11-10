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
import com.shipper.service.CurrentDateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/date")
@Api(value = "/date", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Current Date API's" }, hidden = false)
@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 401, message = "Not Authorized"), @ApiResponse(code = 403, message = "Not Authenticated"),
		@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 500, message = "Internal Server Error") })
@Validated
public class CurrentDateController {

	@Autowired
	private CurrentDateService currentDateService;

	@ApiOperation(value = "Current Date", response = String.class, httpMethod = "GET", notes = "Current Date")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = String.class) })
	@GetMapping(path = "/getCurrentDate")
	@ResponseBody
	public ResponseEntity<RestResponse<String>> getCurrentDate() {
		return RestUtils.successResponse(currentDateService.getCurrentDate());
	}

}
