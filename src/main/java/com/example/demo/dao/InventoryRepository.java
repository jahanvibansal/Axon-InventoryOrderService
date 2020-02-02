
  package com.example.demo.dao;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.example.demo.dto.Inventory;
  
  @Repository public interface InventoryRepository extends
  JpaRepository<Inventory, Integer> {
  
  }
 