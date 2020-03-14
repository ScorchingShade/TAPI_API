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
    String UPSERT_SUCCESS=">>Data saved successfully";
    String UPSERT_FAILURE="--Sorry could not save your data, please ensure all the parameters are added successfully";

    /***
     * Save to mongo
     * @param jsonObject
     * @param storeRepo
     */
    public String saveDocumentToMongo(JsonObject jsonObject, StoreRepo storeRepo){
        String response="";
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
            response=UPSERT_SUCCESS;
            System.out.println(UPSERT_SUCCESS);
            return response;
        } catch (Exception e) {
            response=UPSERT_FAILURE;
            System.out.println(UPSERT_FAILURE);
            return response;
        }

    }

}
