/*
 * package com.example.demo.handler;
 * 
 * import org.axonframework.eventhandling.EventHandler; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.example.demo.dao.InventoryRepository; import
 * com.example.demo.dto.Inventory; import
 * com.example.demo.events.InventoryInsertedEvent; import
 * com.example.demo.events.InventoryUpdatedEvent;
 * 
 * @Service public class InventoryInsertedHandler {
 * 
 * @Autowired InventoryRepository rep;
 * 
 * @EventHandler public void on (InventoryInsertedEvent event) { rep.save(new
 * Inventory(Integer.parseInt(event.getInventoryId()), event.getProductId(),
 * event.getSku(), event.getQuantity())); }
 * 
 * @EventHandler public void on (InventoryUpdatedEvent event) { rep.save(new
 * Inventory(event.getInventoryId(), event.getProductId(),
 * event.getQuantity())); } }
 */