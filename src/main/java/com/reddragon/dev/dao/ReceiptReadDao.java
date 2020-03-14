package com.reddragon.dev.dao;

import com.reddragon.dev.repository.StoreRepo;

import java.util.List;

public interface ReceiptReadDao {

    List<String> fetchDataById(List<String> id, StoreRepo storeRepo);

}
