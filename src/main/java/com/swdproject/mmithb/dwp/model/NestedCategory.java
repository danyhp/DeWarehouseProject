package com.swdproject.mmithb.dwp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "nested_category")
//@EntityListeners(AuditingEntityListener.class)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getIndentedCategories",
                procedureName = "show_indent",
                resultClasses = NestedCategory.class),
        @NamedStoredProcedureQuery(name = "addNewCategory",
                procedureName = "add_new_category"),
        @NamedStoredProcedureQuery(name = "addNewSubcategory",
                procedureName = "add_new_subcategory",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "category_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "parent_name", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "updateCategory",
                procedureName = "update_category",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "category_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "category_old_name", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "deleteCategory",
                procedureName = "delete_category",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "category_name", type = String.class)
                })
})
public class NestedCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private Integer lft;

    @Column
    @NotBlank
    private Integer rgt;

    @ManyToOne
    private NestedCategory parent;

    @OneToMany(mappedBy = "parent")
    private Collection<NestedCategory> node;

//    @OneToMany(mappedBy = "NestedCategory", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Item> items = new ArrayList<>();

    // Getter and Setter

    public Long getId() {
        return id;
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

    public NestedCategory getParent() {
        return parent;
    }

    public void setParent(NestedCategory parent) {
        this.parent = parent;
    }

}