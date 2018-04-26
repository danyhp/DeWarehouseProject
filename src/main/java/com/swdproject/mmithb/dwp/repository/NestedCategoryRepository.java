package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NestedCategoryRepository extends JpaRepository<NestedCategory, Long>, NestedCategoryRepositoryCustom {

    @Procedure(name = "add_new_subcategory")
    void addNewSubcategory(@Param("category_name") String category_name, @Param("parent_name") String parent_name);


}
