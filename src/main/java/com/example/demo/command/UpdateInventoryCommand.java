package com.example.demo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateInventoryCommand {

	@TargetAggregateIdentifier
	private  int inventoryId;

	private String productId;

	private  Integer quantity;
}
