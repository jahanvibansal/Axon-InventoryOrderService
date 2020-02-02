package com.example.demo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertInventoryCommand {
	
	@TargetAggregateIdentifier
	private  int inventoryId;

	private String productId;
	private  String sku;

	private  Integer quantity;
}

