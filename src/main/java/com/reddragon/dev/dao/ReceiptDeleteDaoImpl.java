package com.reddragon.dev.dao;

import com.reddragon.dev.model.ReceiptModel;
import com.reddragon.dev.repository.StoreRepo;

import java.util.Iterator;
import java.util.List;

public class ReceiptDeleteDaoImpl implements ReceiptDeleteDao {

    private String DELETE_SUCCESS = "--Deleted entries with id ";
    private String DELETE_FAILED = "--Delete failed, please check the id again";

    @Override
    public String deleteReceiptById(List<String> id, StoreRepo storeRepo) {

        String mongoResponse = "";
        try {
            Iterator x = id.iterator();
            while (x.hasNext()) {
                List<ReceiptModel> rModel = storeRepo.findAllByIdEquals((String) x.next());
                Iterator i = rModel.iterator();

                while (i.hasNext()) {
                    storeRepo.delete((ReceiptModel) i.next());
                }

                System.out.println(DELETE_SUCCESS + id);
                mongoResponse = DELETE_SUCCESS + id;
            }
            if (mongoResponse.equals("")) {
                throw new Exception();
            } else {
                return mongoResponse;
            }


        } catch (Exception e) {
            return DELETE_FAILED;
        }
    }
}
