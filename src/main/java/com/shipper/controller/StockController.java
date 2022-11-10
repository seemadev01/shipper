package com.shipper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shipper.common.utils.RestResponse;
import com.shipper.common.utils.RestUtils;
import com.shipper.common.utils.Utils;
import com.shipper.dto.FiltersDto;
import com.shipper.service.StockService;
import com.shippper.pojo.Stock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/product")
@Api(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Product API's" }, hidden = false)
@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 401, message = "Not Authorized"), @ApiResponse(code = 403, message = "Not Authenticated"),
		@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 500, message = "Internal Server Error") })
@Validated
public class StockController {

	@Autowired
	private StockService stockService;

	@ApiOperation(value = "Get Product List", response = Stock.class, httpMethod = "POST", notes = "Filters List: <br>&#9679; PRODUCT_CODE <br>&#9679; PRODUCT_CODE_IN <br>&#9679; BATCH_NUMBER <br>&#9679; BATCH_NUMBER_IN <br>&#9679; MANUFACTURING_DATE <br>&#9679; WAREHOUSE_CODE <br>&#9679; WAREHOUSE_CODE_IN <br>&#9679; QUANTITY <br>&#9679; EXPIRY_DATE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = Stock.class) })
	@PostMapping(path = "/getAllProducts")
	@ResponseBody
	public ResponseEntity<RestResponse<Page<Stock>>> getAllProduct(
			@RequestBody(required = false) List<FiltersDto> filter, @RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String sortingColumn,
			@RequestParam(required = false) Direction direction) {
		if (Boolean.TRUE.equals(Utils.checkCollectionIsEmpty(filter)))
			filter = new ArrayList<>();
		return RestUtils.successResponse(stockService.findAll(filter, pageNumber, pageSize, sortingColumn, direction));
	}

}
