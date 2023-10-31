package com.Microservices.Inventoryservice.Service;


import com.Microservices.Inventoryservice.DTO.InventoryResponse;
import com.Microservices.Inventoryservice.Model.Inventory;
import com.Microservices.Inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder().SkuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }

}
