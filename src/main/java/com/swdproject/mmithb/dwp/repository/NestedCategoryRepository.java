package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NestedCategoryRepository extends JpaRepository<NestedCategory, Long> {

//    @Modifying
//    @Query(value = "SELECT node.category_id, CONCAT( REPEAT('\t', (COUNT(parent.name) - 1) ) , CONCAT('->  ') , node.name) AS name\n" +
//            ", node.lft, node.rgt\n" +
//            "FROM category AS node,\n" +
//            "        category AS parent\n" +
//            "WHERE node.lft BETWEEN parent.lft AND parent.rgt\n" +
//            "GROUP BY node.name\n" +
//            "ORDER BY node.lft;", nativeQuery = true)
//    List<NestedCategory> showIndent();

}
