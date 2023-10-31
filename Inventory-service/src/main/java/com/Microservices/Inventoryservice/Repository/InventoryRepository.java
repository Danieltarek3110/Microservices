package com.Microservices.Inventoryservice.Repository;

import com.Microservices.Inventoryservice.Model.Inventory;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
//    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> SkuCode);

    }

