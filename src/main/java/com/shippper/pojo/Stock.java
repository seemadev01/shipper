
package com.shippper.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Stock.TABLE_NAME)
public class Stock implements Serializable {

	private static final long serialVersionUID = 3996567577495114816L;

	public static final String TABLE_NAME = "Stock";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", columnDefinition = "bigInt(5) NOT NULL PRIMARY KEY AUTO_INCREMENT")
	private Long id;

	@Column(name = "ProductCode", columnDefinition = "varchar(100) DEFAULT NULL")
	private String productCode;

	@Column(name = "BatchNumber", columnDefinition = "varchar(100) DEFAULT NULL")
	private String batchNumber;

	@Column(name = "ExpiryDate", columnDefinition = "datetime DEFAULT NULL")
	private Date expiryDate;

	@Column(name = "ManufacturingDate", columnDefinition = "datetime DEFAULT NULL")
	private Date manufacturingDate;

	@Column(name = "WarehouseCode", columnDefinition = "bigint(11) DEFAULT NULL")
	private Long warehouseCode;

	@Column(name = "Quantity", columnDefinition = "int(11)")
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", productCode=" + productCode + ", batchNumber=" + batchNumber + ", expiryDate="
				+ expiryDate + ", manufacturingDate=" + manufacturingDate + ", warehouseCode=" + warehouseCode
				+ ", quantity=" + quantity + "]";
	}

}