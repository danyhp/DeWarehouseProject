package com.swdproject.mmithb.dwp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "nested_category")
//@EntityListeners(AuditingEntityListener.class)
@NamedStoredProcedureQuery(name = "getIndentedCategories", procedureName = "show_indent", resultClasses = NestedCategory.class)
public class NestedCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    private String name;

    @NotBlank
    private Integer lft;

    @NotBlank
    private  Integer rgt;

    // Getter and Setter


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }
}