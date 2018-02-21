package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserAccessor extends JpaRepository<User,Long>{
}
