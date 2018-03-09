package com.kb.dndchar.accessors.impl;

import com.kb.dndchar.accessors.ISpellAccessorCustom;
import com.kb.dndchar.domains.DomainSpell;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SpellAccessorCustom implements ISpellAccessorCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public List<DomainSpell> getSpellsByCharId(Long charId) {
        Query query = entityManager.createNativeQuery(
                "SELECT s.spell_id, s.spell_name\n" +
                        "FROM HAS_SPELL NATURAL JOIN SPELLS as S\n" +
                        "WHERE char_id = ?",
        DomainSpell.class);
        query.setParameter(1,charId);
        List<DomainSpell> spellList = query.getResultList();
        return spellList;
    }
}
