package com.shipper.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shipper.dao.IStockDaoService;
import com.shipper.repository.StockRepository;
import com.shipper.utils.QuerySpecificationBuilder;
import com.shippper.pojo.Stock;

@Service
public class StockDaoServiceImpl implements IStockDaoService {

	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Page<Stock> findAll(Specification<QuerySpecificationBuilder> buildCriteria, Integer pageNumber, int pageSize,
			Sort sorting) {
		return stockRepository.findAll(buildCriteria, PageRequest.of(pageNumber, pageSize, sorting));
	}

}
