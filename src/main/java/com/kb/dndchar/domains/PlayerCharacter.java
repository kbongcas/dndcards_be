package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="characters")
public class PlayerCharacter {

    @Id
    @Column(name = "char_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "char_name")
    private String userName;
}
