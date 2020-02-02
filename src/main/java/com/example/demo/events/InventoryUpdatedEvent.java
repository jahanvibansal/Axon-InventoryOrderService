package com.example.demo.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryUpdatedEvent {

		private final String productId;
		
		private String inventoryId;

		private final Integer quantity;

}
	