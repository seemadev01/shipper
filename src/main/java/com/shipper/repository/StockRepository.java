package com.shipper.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shippper.pojo.Stock;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {

	Page<Stock> findAll(Specification<?> build, Pageable pageable);

}
