package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="spells")
public class DomainSpell {

    @Id
    @Column(name = "spell_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long spellId;

    @Column(name = "spell_name")
    private String spellName;
}
