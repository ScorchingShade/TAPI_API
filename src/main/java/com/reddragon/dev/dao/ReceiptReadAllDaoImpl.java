package com.reddragon.dev.dao;

import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;

import java.util.List;

public class ReceiptReadAllDaoImpl implements ReceiptReadAllDao {
    @Override
    public List<ReceiptModel> fetchAll(StoreRepo storeRepo) {
        try {
            return storeRepo.findAll();
        } catch (Exception e) {
            System.out.println("No data found");
            return storeRepo.findAll();
        }
    }
}
