package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainSpell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpellAccessor extends JpaRepository<DomainSpell, Long>, ISpellAccessorCustom {
}
