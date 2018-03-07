package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="characters")
@SecondaryTable(name="ability_scores_set",
        pkJoinColumns = @PrimaryKeyJoinColumn(name="char_id", referencedColumnName="char_id")
)
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

    @Column(name = "str_score", table = "ability_scores_set")
    private Integer strengthScore;

}
