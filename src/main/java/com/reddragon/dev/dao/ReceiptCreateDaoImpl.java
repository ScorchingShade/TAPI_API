package com.reddragon.dev.dao;

import com.google.gson.JsonObject;
import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;
import lombok.NoArgsConstructor;

/**
 * @author ankush
 * non abstracted create receipt operation
 */
@NoArgsConstructor
public class ReceiptCreateDaoImpl implements ReceiptCreateDao {
    private String UPSERT_SUCCESS=">>Data saved successfully";
    private String UPSERT_FAILURE="--Sorry could not save your data, please ensure all the parameters are added successfully";

    /***
     * Save to mongo
     * @param jsonObject
     * @param storeRepo
     */
    public String saveDocumentToMongo(JsonObject jsonObject, StoreRepo storeRepo){
        try {
        ReceiptModel receiptModel = new ReceiptModel(
                jsonObject.get("id").toString().trim().replaceAll("\"",""),
                jsonObject.get("name").toString().trim().replaceAll("\"",""),
                jsonObject.get("address").toString().trim().replaceAll("\"",""),
                jsonObject.get("amount").toString().trim().replaceAll("\"",""),
                jsonObject.get("payment_type").toString().trim().replaceAll("\"",""),
                jsonObject.get("date").toString().trim().replaceAll("\"",""),
                jsonObject.get("receiver").toString().trim().replaceAll("\"","")
        );

            storeRepo.save(receiptModel);
            System.out.println(UPSERT_SUCCESS);
            return UPSERT_SUCCESS;
        } catch (Exception e) {
            System.out.println(UPSERT_FAILURE);
            return UPSERT_FAILURE;
        }

    }

}
