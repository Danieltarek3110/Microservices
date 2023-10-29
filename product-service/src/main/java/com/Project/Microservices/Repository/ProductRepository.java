package com.Project.Microservices.Repository;

import com.Project.Microservices.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product , String> {


}
