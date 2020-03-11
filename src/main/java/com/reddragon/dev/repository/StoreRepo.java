package com.reddragon.dev.repository;

import com.reddragon.dev.model.ReceiptModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface StoreRepo extends MongoRepository<ReceiptModel,String> {
}
