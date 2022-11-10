package com.shipper.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.shipper.utils.QuerySpecificationBuilder;
import com.shippper.pojo.Stock;

public interface IStockDaoService {

	Page<Stock> findAll(Specification<QuerySpecificationBuilder> buildCriteria, Integer zeroInt, int maxValue,
			Sort sorting);
}
