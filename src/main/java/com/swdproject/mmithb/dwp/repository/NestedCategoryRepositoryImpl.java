package com.swdproject.mmithb.dwp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class NestedCategoryRepositoryImpl implements NestedCategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getIndentedCategories() {
        StoredProcedureQuery showIndented =
                entityManager.createNamedStoredProcedureQuery("getIndentedCategories");
        return showIndented.getResultList();
    }

    @Override
    public void addNewCategory() {
    }

    @Override
    public void addNewSubcategory(String newcategory, String parent) {
        StoredProcedureQuery addNewSubcategory =
                entityManager.createNamedStoredProcedureQuery("addNewSubcategory");

        addNewSubcategory.setParameter("parent_name", parent);
        addNewSubcategory.setParameter("category_name", newcategory);

        addNewSubcategory.execute();
    }

    @Override
    public void updateCategory(String newcategory, String oldcategory) {
        StoredProcedureQuery updateCategory =
                entityManager.createNamedStoredProcedureQuery("updateCategory");

        updateCategory.setParameter("category_name", newcategory);
        updateCategory.setParameter("category_old_name", oldcategory);

        updateCategory.execute();
    }
}
