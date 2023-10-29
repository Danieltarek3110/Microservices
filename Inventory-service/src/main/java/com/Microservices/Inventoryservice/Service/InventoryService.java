package com.Microservices.Inventoryservice.Service;


import com.Microservices.Inventoryservice.Model.Inventory;
import com.Microservices.Inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){

        return inventoryRepository.findBySkuCode().isPresent();
    }

}
