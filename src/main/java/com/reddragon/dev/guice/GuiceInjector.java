package com.reddragon.dev.guice;

import com.google.inject.AbstractModule;
import com.reddragon.dev.dao.ReceiptCreateDao;
import com.reddragon.dev.dao.ReceiptCreateDaoImpl;
import com.reddragon.dev.dao.ReceiptReadDao;
import com.reddragon.dev.dao.ReceiptReadDaoImpl;

/**
 * @author ankush guice injector class
 */
public class GuiceInjector extends AbstractModule {
    @Override
    protected void configure() {

        bind(ReceiptCreateDao.class).to(ReceiptCreateDaoImpl.class).asEagerSingleton();
        bind(ReceiptReadDao.class).to(ReceiptReadDaoImpl.class).asEagerSingleton();

    }
}
