package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NestedCategoryRepository extends JpaRepository<NestedCategory, Long>, NestedCategoryRepositoryCustom {


}
