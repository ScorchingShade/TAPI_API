package com.reddragon.dev.dao;

import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;

import java.util.List;

public interface ReceiptReadAllDao {
    List<ReceiptModel> fetchAll(StoreRepo storeRepo);
}
