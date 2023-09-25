package com.appsdeveloperblog.estore.ProductsService.command.rest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {
	
	@Autowired  private final Environment enviroment;
	@Autowired  private final CommandGateway commandGateway;
	 
	
	public ProductsCommandController(Environment enviroment, CommandGateway commandGateway) {
		this.enviroment = enviroment;
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
		
		CreateProductCommand createProductCommand =  CreateProductCommand.builder()
		.price(createProductRestModel.getPrice())
		.quatity(createProductRestModel.getQuantity())
		.title(createProductRestModel.getTitle())
		.productId(UUID.randomUUID().toString()).build();
		
		String returnValue;
		
		returnValue = commandGateway.sendAndWait(createProductCommand);
		
//		try {
//			returnValue = commandGateway.sendAndWait(createProductCommand);
//			
//		} catch (Exception ex) {
//			returnValue = ex.getLocalizedMessage();
//		}
		return returnValue;
	}
	
//	@GetMapping
//	public String getProduct() {
//		return "HTTP GET Handled " + env.getProperty("local.server.port");
//	}
//	
//	@PutMapping
//	public String updateProduct() {
//		return "HTTP PUT Handled";
//	}
//	
//	@DeleteMapping
//	public String deleteProduct() {
//		return "HTTP DELETE handled";
//	}
}


























