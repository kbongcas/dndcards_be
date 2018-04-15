package com.kb.dndchar.domains;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="users")
public class DomainUser {

    @Id
    @Column(name = "user_name")
    String username;
}
