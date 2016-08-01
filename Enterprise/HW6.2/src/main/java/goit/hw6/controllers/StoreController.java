package goit.hw6.controllers;

import goit.hw6.model.DaoInterfaces.StoreDao;

public class StoreController {

    private StoreDao storeDao;


    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }
}
