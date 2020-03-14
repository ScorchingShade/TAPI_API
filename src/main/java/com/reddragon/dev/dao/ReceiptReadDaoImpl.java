package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReceiptReadDaoImpl implements  ReceiptReadDao {
    @Override
    public List<String> fetchDataById(List<String> id, StoreRepo storeRepo) {
        List<String> mongoResponse = new ArrayList<>();
        try {
            Iterator x = id.iterator();
            while (x.hasNext()) {
                String data = storeRepo.findByIdEquals((String) x.next()).toString();
                mongoResponse.add(data);
            }
            if (mongoResponse.isEmpty()) {
                throw new Exception();
            } else {
                return mongoResponse;
            }
        } catch (Exception e) {
            mongoResponse.add("No data added");
            return mongoResponse;
        }

    }
}
