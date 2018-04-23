package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;

import java.util.List;

public interface NestedCategoryRepositoryCustom {

    List<NestedCategory> getIndentedCategories();
}
