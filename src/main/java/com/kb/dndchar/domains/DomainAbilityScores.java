package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ability_scores_set")
public class DomainAbilityScores {

    @Id
    @Column(name = "char_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long charId;

    @Column(name = "str_score")
    private Integer strengthScore;

    @Column(name = "dex_score")
    private Integer dexterityScore;

    @Column(name = "con_score ")
    private Integer constitutionScore;

    @Column(name = "int_score")
    private Integer intelligenceScore;

    @Column(name = "wis_score")
    private Integer wisdomScore;

    @Column(name = "chr_score")
    private Integer charismaScore;

    @OneToOne(mappedBy = "domainAbilityScores")
    private DomainCharacter domainCharacter;

}
