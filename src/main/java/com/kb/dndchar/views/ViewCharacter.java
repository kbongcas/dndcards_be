package com.kb.dndchar.views;

import lombok.Data;

@Data
public class ViewCharacter {
    private Long charId;
    private String charName;
    private Long lastUpdated;
    private Long createdOn;
    private ViewAbilityScores viewAbilityScores;
}
