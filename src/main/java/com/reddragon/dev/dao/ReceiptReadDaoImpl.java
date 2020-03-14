package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

public class ReceiptReadDaoImpl implements  ReceiptReadDao {
    @Override
    public String fetchDataById(String id, StoreRepo storeRepo) {
        String response = null;
        try {
            response = storeRepo.findByIdEquals(id).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
