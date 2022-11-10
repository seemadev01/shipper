package com.shipper.transformers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.shipper.common.utils.Utils;
import com.shipper.dto.FiltersDto;
import com.shipper.enums.FilterKeys;
import com.shipper.utils.QuerySpecificationBuilder;
import com.shipper.utils.SearchOperation;

public class StockFiltersTransformer {

	private StockFiltersTransformer() {
		super();
	}

	public static Specification<QuerySpecificationBuilder> buildCriteria(List<FiltersDto> filters) {
		QuerySpecificationBuilder qb = new QuerySpecificationBuilder();
		if (Boolean.TRUE.equals(Utils.checkCollectionIsNotEmpty(filters))) {
			filters.forEach(filter -> {
				if (FilterKeys.ID.equals(filter.getKey())) {
					filterId(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.PRODUCT_CODE.equals(filter.getKey())) {
					filterProductCode(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.PRODUCT_CODE_IN.equals(filter.getKey())) {
					filterProductCodeIn(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.BATCH_NUMBER.equals(filter.getKey())) {
					filterBatchNumber(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.BATCH_NUMBER_IN.equals(filter.getKey())) {
					filterBatchNumberIn(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.MANUFACTURING_DATE.equals(filter.getKey())) {
					filterManufacturingDate(qb, filter.getKey(), filter.getDateValue());
				} else if (FilterKeys.WAREHOUSE_CODE.equals(filter.getKey())) {
					filterWarehouseCode(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.WAREHOUSE_CODE_IN.equals(filter.getKey())) {
					filterWarehouseCodeIn(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.QUANTITY.equals(filter.getKey())) {
					filterQty(qb, filter.getKey(), filter.getValue());
				} else if (FilterKeys.EXPIRY_DATE.equals(filter.getKey())) {
					filterExpiryDate(qb, filter.getKey(), filter.getDateValue());
				}
			});
		}
		return qb.build();
	}

	public static void filterId(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.ID.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("id", SearchOperation.EQUALITY, Integer.valueOf(value));
		}
	}

	public static void filterProductCode(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.PRODUCT_CODE.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("productCode", SearchOperation.STARTS_WITH, value.trim());
		}
	}

	public static void filterProductCodeIn(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.PRODUCT_CODE_IN.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("productCode", SearchOperation.STRINGIN, value.trim());
		}
	}

	public static void filterBatchNumber(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.BATCH_NUMBER.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("batchNumber", SearchOperation.EQUALITY, Integer.valueOf(value));
		}
	}

	public static void filterBatchNumberIn(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.BATCH_NUMBER_IN.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("batchNumber", SearchOperation.STRINGIN, value.trim());
		}
	}

	public static void filterManufacturingDate(QuerySpecificationBuilder qb, FilterKeys key, Date value) {
		if (FilterKeys.MANUFACTURING_DATE.equals(key) && Objects.nonNull(value)) {
			List<Date> minMaxDate = Utils.getMinMaxDate(value);
			qb.with("manufacturingDate", SearchOperation.DATE_GREATER_THAN_EQUALS, minMaxDate.get(0));
			qb.with("manufacturingDate", SearchOperation.DATE_LESS_THAN_EQUAL, minMaxDate.get(1));
		}
	}

	public static void filterExpiryDate(QuerySpecificationBuilder qb, FilterKeys key, Date value) {
		if (FilterKeys.EXPIRY_DATE.equals(key) && Objects.nonNull(value)) {
			List<Date> minMaxDate = Utils.getMinMaxDate(value);
			qb.with("expiryDate", SearchOperation.DATE_GREATER_THAN_EQUALS, minMaxDate.get(0));
			qb.with("expiryDate", SearchOperation.DATE_LESS_THAN_EQUAL, minMaxDate.get(1));
		}
	}

	public static void filterWarehouseCodeIn(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.WAREHOUSE_CODE_IN.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("warehouseLocation", SearchOperation.LONGIN, value.trim());
		}
	}

	public static void filterWarehouseCode(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.WAREHOUSE_CODE.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("warehouseLocation", SearchOperation.EQUALITY, Long.valueOf(value.trim()));
		}
	}

	public static void filterQty(QuerySpecificationBuilder qb, FilterKeys key, String value) {
		if (FilterKeys.QUANTITY.equals(key) && StringUtils.isNotBlank(value)) {
			qb.with("quantity", SearchOperation.EQUALITY, Long.valueOf(value.trim()));
		}
	}

}
