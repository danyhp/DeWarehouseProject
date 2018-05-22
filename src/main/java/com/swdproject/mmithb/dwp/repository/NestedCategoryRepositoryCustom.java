package com.swdproject.mmithb.dwp.repository;

import java.util.List;

public interface NestedCategoryRepositoryCustom {

    List getIndentedCategories();

    List getPrefixCategory();

    void addNewCategory();

    void addNewSubcategory(String parent, String newcategory);

    void updateCategory(String newcategory, String oldcategory);

    void deleteCategory(String categoryname);

}
