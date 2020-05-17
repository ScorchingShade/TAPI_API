package com.reddragon.dev.guice;

import com.google.inject.AbstractModule;
import com.reddragon.dev.dao.*;

/**
 * @author ankush guice injector class
 */
public class GuiceInjector extends AbstractModule {
    @Override
    protected void configure() {

        bind(ReceiptCreateDao.class).to(ReceiptCreateDaoImpl.class).asEagerSingleton();
        bind(ReceiptReadDao.class).to(ReceiptReadDaoImpl.class).asEagerSingleton();
        bind(ReceiptDeleteDao.class).to(ReceiptDeleteDaoImpl.class).asEagerSingleton();
        bind(ReceiptReadAllDao.class).to(ReceiptReadAllDaoImpl.class).asEagerSingleton();

    }
}
