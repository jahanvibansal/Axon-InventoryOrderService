package com.example.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.command.InsertInventoryCommand;
import com.example.demo.command.UpdateInventoryCommand;
import com.example.demo.dto.Inventory;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
	
	@Autowired CommandGateway gateway;
	
	@PostMapping
	public CompletableFuture<Object> insertInventory(@RequestBody Inventory i) {
		System.out.println(i);
		return gateway.send(new InsertInventoryCommand(i.getInventoryId(), i.getProductId(), i.getSku(), i.getQuantity()));
	}
	
	@PutMapping
	public CompletableFuture<Object> updateInventory(@RequestBody Inventory i) {
		return gateway.send(new UpdateInventoryCommand(i.getInventoryId(), i.getProductId(), i.getQuantity()));
	}

}
