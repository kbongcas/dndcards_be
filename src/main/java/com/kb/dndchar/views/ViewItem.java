package com.kb.dndchar.views;
import lombok.Data;

@Data
public class ViewItem {
    private Long itemId;
    private String itemName;
    private String itemType;
    private String itemCost;
    private String itemWeight;
    private String itemDesc;
}
