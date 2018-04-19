package com.swdproject.mmithb.dwp.repository;

import com.swdproject.mmithb.dwp.model.Category;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Modifying
//    @Query(value = "SELECT node.category_id, CONCAT( REPEAT('\t', (COUNT(parent.name) - 1) ) , CONCAT('->  ') , node.name) AS name\n" +
//            ", node.lft, node.rgt\n" +
//            "FROM category AS node,\n" +
//            "        category AS parent\n" +
//            "WHERE node.lft BETWEEN parent.lft AND parent.rgt\n" +
//            "GROUP BY node.name\n" +
//            "ORDER BY node.lft;", nativeQuery = true)
//    List<Category> showIndent();

    List<Category> findAllByNameContains(String name);

//    @Modifying
//    @Query(value = "LOCK TABLES category WRITE;\n" +
//            "\n" +
//            "SELECT @myLeft := lft FROM category\n" +
//            "\n" +
//            "WHERE name = 'MP3 PLAYERS';\n" +
//            "\n" +
//            "UPDATE category SET rgt = rgt + 2 WHERE rgt > @myLeft;\n" +
//            "UPDATE category SET lft = lft + 2 WHERE lft > @myLeft;\n" +
//            "\n" +
//            "INSERT INTO category(name, lft, rgt) VALUES('FLASH', @myLeft + 1, @myLeft + 2);\n" +
//            "\n" +
//            "UNLOCK TABLES;", nativeQuery = true)
//    Category addSub(Category category);
}
