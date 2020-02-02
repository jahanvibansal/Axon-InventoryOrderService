package com.example.demo.dto;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.demo.command.InsertInventoryCommand;
import com.example.demo.command.UpdateInventoryCommand;
import com.example.demo.events.InventoryInsertedEvent;
import com.example.demo.events.InventoryUpdatedEvent;

import lombok.Data;

@Aggregate
@Data
public class InventoryAggregate {
	@AggregateIdentifier
	private int inventoryId;
	private String productId;
	private String sku;
	private Integer quantity;
	
	public InventoryAggregate() {
	}

	@CommandHandler
	public InventoryAggregate(InsertInventoryCommand command) {
		AggregateLifecycle.apply(new InventoryInsertedEvent(command.getProductId(), String.valueOf(command.getInventoryId()),
				command.getSku(), command.getQuantity()));
	}

	@CommandHandler
	public void updateInventory(UpdateInventoryCommand command) {
		AggregateLifecycle.apply(new InventoryUpdatedEvent(command.getProductId(), String.valueOf(command.getInventoryId()),
				command.getQuantity()));
	}

	@EventSourcingHandler
	public void on(InventoryUpdatedEvent event) {
		this.quantity -= event.getQuantity();
		this.productId= event.getProductId();
		this.inventoryId= Integer.parseInt(event.getInventoryId());
	}

	@EventSourcingHandler
	public void on(InventoryInsertedEvent event) {
		this.quantity = event.getQuantity();
		this.productId= event.getProductId();
		this.inventoryId= Integer.parseInt(event.getInventoryId());
		this.sku= event.getSku();
	}
}
