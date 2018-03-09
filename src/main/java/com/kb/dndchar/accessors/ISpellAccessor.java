package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainSpell;
import org.springframework.data.repository.CrudRepository;

public interface ISpellAccessor extends CrudRepository<DomainSpell, Long>, ISpellAccessorCustom {
}
