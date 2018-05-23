package com.swdproject.mmithb.dwp.repository;

import javax.transaction.Transactional;

@Transactional
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @Override
    public void addNewItem(String parent, String itemName, String manufacturer, int qty) {

    }
}
