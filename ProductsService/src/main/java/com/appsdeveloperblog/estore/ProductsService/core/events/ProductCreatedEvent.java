package com.appsdeveloperblog.estore.ProductsService.core.events;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductCreatedEvent {

	
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quatity;
	
	public ProductCreatedEvent() {
	}
	
	
	
	
	
}
