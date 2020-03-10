package com.reddragon.dev.repository;

import com.reddragon.dev.model.ReceiptModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StoreRepoImpl implements StoreRepo {
    @Override
    public <S extends ReceiptModel> S save(S s) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ReceiptModel> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<ReceiptModel> findAll() {
        List<ReceiptModel> list = new ArrayList<>();
        list.add(new ReceiptModel());
        return list;
    }

    @Override
    public Iterable<ReceiptModel> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ReceiptModel receiptModel) {

    }

    @Override
    public void deleteAll(Iterable<? extends ReceiptModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ReceiptModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ReceiptModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> S insert(S s) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ReceiptModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ReceiptModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ReceiptModel> boolean exists(Example<S> example) {
        return false;
    }
}
