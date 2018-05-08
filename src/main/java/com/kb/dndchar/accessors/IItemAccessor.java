package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemAccessor  extends JpaRepository<DomainItem, Long>, IItemAccessorCustom{
}
