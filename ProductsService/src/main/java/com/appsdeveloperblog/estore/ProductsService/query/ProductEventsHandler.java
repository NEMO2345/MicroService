package com.appsdeveloperblog.estore.ProductsService.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.ProductsService.core.data.ProductEntity;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductRepository;
import com.appsdeveloperblog.estore.ProductsService.core.events.ProductCreatedEvent;

@Component
@ProcessingGroup("product-group")
public class ProductEventsHandler {
	
	private final ProductRepository productRepository;
	
	public ProductEventsHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@EventHandler
	public void on(ProductCreatedEvent event) {
		
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);
		
		productRepository.save(productEntity);
	}
}
