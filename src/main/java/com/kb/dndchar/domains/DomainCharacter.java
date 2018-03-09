package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="characters")
public class DomainCharacter {

    @Id
    @Column(name = "char_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charId;

    @Column(name = "char_name")
    private String charName;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="char_id")
    private DomainAbilityScores domainAbilityScores;

}
