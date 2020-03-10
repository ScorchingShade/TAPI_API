package com.reddragon.dev.repository;

import com.reddragon.dev.model.ReceiptModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends MongoRepository<ReceiptModel,String> {
}
