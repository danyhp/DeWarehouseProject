package com.swdproject.mmithb.dwp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getPrefixCategory",
                procedureName = "show_indent2",
                resultClasses = NestedCategoryPref.class)
})
public class NestedCategoryPref implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private Integer lft;

    @Column
    @NotBlank
    private Integer rgt;

    @ManyToOne
    private NestedCategoryPref parent;

    @OneToMany(mappedBy = "parent")
    private Collection<NestedCategoryPref> node;


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

    public NestedCategoryPref getParent() {
        return parent;
    }

    public void setParent(NestedCategoryPref parent) {
        this.parent = parent;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}