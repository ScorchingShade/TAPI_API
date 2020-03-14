package com.reddragon.dev.dao;

import com.google.gson.JsonObject;
import com.reddragon.dev.repository.StoreRepo;

/***
 * @author ankush
 * abstracted Create receipt operation
 */
public interface ReceiptCreateDao {
    void saveDocumentToMongo(JsonObject jsonObject, StoreRepo storeRepo);
}
