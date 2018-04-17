package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccessor extends JpaRepository<DomainUser, String>, IUserAccessorCustom {

    DomainUser findByUsername(String username);
}
