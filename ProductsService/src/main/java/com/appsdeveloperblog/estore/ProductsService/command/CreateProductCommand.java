package com.appsdeveloperblog.estore.ProductsService.command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class CreateProductCommand {
	
	@TargetAggregateIdentifier
	private final String productId;
	private final String title;
	private final BigDecimal price;
	private final Integer quatity;
	

}
