package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.Item;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByCategoryId_NameContains(@NotBlank String categoryId_name);

    List<Item> findAllByCategoryIdContains(NestedCategory categoryId);

    List<Item> findAllByNameContains(@NotBlank String name);
}
