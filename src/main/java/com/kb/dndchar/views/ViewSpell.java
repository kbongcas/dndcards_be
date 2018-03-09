package com.kb.dndchar.views;

import lombok.Data;

@Data
public class ViewSpell {
    private Long spellId;
    private String spellName;
    private Boolean isRitual;
    private String ritualName;
    private Integer level;
    private String castingTime;
    private String range;
    private String duration;
    private String components;
    private String materials;
    private String spellDesc;
    private String higherLevelDescOne;
    private String higherLevelDescTwo;
}

