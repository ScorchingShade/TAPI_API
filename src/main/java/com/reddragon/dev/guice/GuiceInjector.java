package com.reddragon.dev.guice;

import com.google.inject.AbstractModule;
import com.reddragon.dev.repository.StoreRepo;
import com.reddragon.dev.repository.StoreRepoImpl;

public class GuiceInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(StoreRepo.class).to(StoreRepoImpl.class);
    }
}
