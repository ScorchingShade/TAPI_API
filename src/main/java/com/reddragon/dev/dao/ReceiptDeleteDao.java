package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

public interface ReceiptDeleteDao {

    String deleteReceiptById(String id, StoreRepo storeRepo);
}
