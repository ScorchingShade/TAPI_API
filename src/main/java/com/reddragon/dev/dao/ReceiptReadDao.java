package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

public interface ReceiptReadDao {

    String fetchDataById(String id, StoreRepo storeRepo);

}
