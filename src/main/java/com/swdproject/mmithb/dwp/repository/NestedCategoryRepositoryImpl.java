package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class NestedCategoryRepositoryImpl implements NestedCategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NestedCategory> getIndentedCategories() {
        StoredProcedureQuery showIndented =
                entityManager.createNamedStoredProcedureQuery("getIndentedCategories");
        return showIndented.getResultList();
    }

}
