package com.kb.dndchar.domains;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="items")
public class DomainItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_cost")
    private String itemCost;

    @Column(name = "item_weight")
    private String itemWeight;

    @Column(name = "item_desc")
    private String itemDesc;
}
