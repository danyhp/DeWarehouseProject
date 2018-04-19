package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
