package com.appsdeveloperblog.estore.ProductsService.query.rest;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductRestModel {

	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quatity;
	
	public ProductRestModel() {
	}
	
	
	
}
