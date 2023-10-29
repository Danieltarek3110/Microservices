package com.Microservices.Inventoryservice.Repository;

import com.Microservices.Inventoryservice.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory , Long> {
    Optional<Inventory> findBySkuCode();

    }

