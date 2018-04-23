package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameContains(String name);


}
