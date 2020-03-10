package com.reddragon.dev.repository;

import com.reddragon.dev.model.ReceiptModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepo extends MongoRepository<ReceiptModel,String> {
}
