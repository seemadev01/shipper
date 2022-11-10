package com.shipper.service;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.shipper.common.utils.Constant;
import com.shipper.common.utils.Logger;
import com.shipper.dao.IStockDaoService;
import com.shipper.dto.FiltersDto;
import com.shipper.transformers.StockFiltersTransformer;
import com.shippper.pojo.Stock;

@Service
public class StockService {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private IStockDaoService stockDaoService;

	private static final String DEFAULT_SORTING_COLUMN = "id";

	public Page<Stock> findAll(List<FiltersDto> filter, Integer pageNumber, Integer pageSize, String sortingColumn,
			Direction direction) {
		log.info("inside StockService of findAll method");
		Sort sorting = getDefaultSorting();
		if (StringUtils.isNotBlank(sortingColumn) && Objects.nonNull(direction)) {
			sorting = Sort.by(direction, sortingColumn);
		}

		if (Objects.isNull(pageNumber) || Objects.isNull(pageSize))
			return stockDaoService.findAll(StockFiltersTransformer.buildCriteria(filter), Constant.ZERO_INT,
					Integer.MAX_VALUE, sorting);

		return stockDaoService.findAll(StockFiltersTransformer.buildCriteria(filter), pageNumber, pageSize, sorting);
	}

	public Sort getDefaultSorting() {
		return Sort.by(Direction.DESC, defaultSortingColumn());
	}

	public String defaultSortingColumn() {
		return DEFAULT_SORTING_COLUMN;
	}

}
