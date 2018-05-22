package com.swdproject.mmithb.dwp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addNewItem(String parent, String itemName, String manufacturer, int qty) {

    }
}
