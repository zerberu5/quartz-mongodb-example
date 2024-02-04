package org.quartzer.persistence;

import org.quartzer.dto.MyData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyDataRepository extends MongoRepository<MyData, String> {
    // You can define custom methods here if needed
}