package com.reddragon.dev.dao;

import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;

import java.util.Iterator;
import java.util.List;

public class ReceiptDeleteDaoImpl implements ReceiptDeleteDao {

    String DELETE_SUCCESS="--Deleted entries with id ";
    String DELETE_FAILED="--Delete failed, please check the id again";

    @Override
    public String deleteReceiptById(String id, StoreRepo storeRepo) {
        String response="";
        try {
            List<ReceiptModel> rModel=storeRepo.findAllByIdEquals(id);
            Iterator i = rModel.iterator();

            while(i.hasNext()){
                storeRepo.delete((ReceiptModel)i.next());
            }

            System.out.println(DELETE_SUCCESS+id);
            return DELETE_SUCCESS+id;

        } catch (Exception e) {
            return DELETE_FAILED;
        }
    }
}
