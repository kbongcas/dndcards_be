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

    public List<DomainSpell> getSpellsByName(String name) {
        Query query = entityManager.createNativeQuery(
                    "SELECT *\n" +
                        "FROM HAS_SPELL NATURAL JOIN SPELLS as S\n" +
                        "WHERE user_name = ?",
        DomainSpell.class);
        query.setParameter(1,name);

        @SuppressWarnings("unchecked")
        List<DomainSpell> spellList = query.getResultList();

        return spellList;
    }
}
