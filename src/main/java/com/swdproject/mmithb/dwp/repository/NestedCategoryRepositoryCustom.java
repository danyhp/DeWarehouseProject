package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;

import java.util.List;

public interface NestedCategoryRepositoryCustom {

    List getIndentedCategories();

    void addNewCategory();

    void addNewSubcategory(String parent, String newcategory);

    void updateCategory(String newcategory, String oldcategory);

}
