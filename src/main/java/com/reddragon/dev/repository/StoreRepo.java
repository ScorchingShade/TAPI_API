package com.reddragon.dev.repository;

import com.reddragon.dev.model.ReceiptModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


/***
 * @author ankush
 * adding the StoreRepo interface to use mongo features
 */
@Component
public interface StoreRepo extends MongoRepository<ReceiptModel,String> {

    //To get multiple results, use list e.g List<ReceiptModel> findAllByIdEquals
    ReceiptModel findByIdEquals(String id);
}
