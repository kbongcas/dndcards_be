package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "users")
public class DomainUser {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

}
