package com.swdproject.mmithb.dwp.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "product")
//@EntityListeners(AuditingEntityListener.class)
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private NestedCategory categoryId;

    @Column
    @NotBlank
    private Integer qty;


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

    public NestedCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(NestedCategory categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
