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

    /***
     * Save to mongo
     * @param jsonObject
     * @param storeRepo
     */
    public void saveDocumentToMongo(JsonObject jsonObject, StoreRepo storeRepo){
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
            System.out.println(">>Data saved successfully");
        } catch (Exception e) {
            System.out.println("--Sorry could not save your data, please ensure all the parameters are added successfully");
        }

    }

}
