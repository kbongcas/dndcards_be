package com.kb.dndchar.domains;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name="spells")
public class DomainSpell {

    @Id
    @Column(name = "spell_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spellId;

    @Column(name = "spell_name")
    private String spellName;

    @Column(name = "ritual")
    private Boolean isRitual;

    @Column(name = "name_ritual")
    private String ritualName;

    @Column(name = "level")
    private Integer level;

    @Column(name = "school")
    private String school;

    @Column(name = "level_school")
    private String schoolLevel;

    @Column(name = "casting_time")
    private String castingTime;

    @Column(name = "range")
    private String range;

    @Column(name = "duration")
    private String duration;

    @Column(name = "components")
    private String components;

    @Column(name = "materials")
    private String materials;

    @Lob
    @Column(name = "spell_desc")
    private String spellDesc;

    @Lob
    @Column(name = "higher_level")
    private String higherLevelDescOne;

    @Lob
    @Column(name = "higher_desc")
    private String higherLevelDescTwo;

    @Column(name = "save")
    private String saveType;

    @Column(name = "class")
    private String classType;

}
