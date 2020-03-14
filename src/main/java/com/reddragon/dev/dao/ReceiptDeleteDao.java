package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

import java.util.List;

public interface ReceiptDeleteDao {

    String deleteReceiptById(List<String> id, StoreRepo storeRepo);
}
