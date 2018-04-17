package com.kb.dndchar.accessors.impl;

import com.kb.dndchar.accessors.IUserAccessorCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserAccessorCustom implements IUserAccessorCustom{

    @PersistenceContext
    private EntityManager entityManager;

    /* Might not be the best way to do this*/
    public void addToHasSpellTable(String name, Long spellID) {
        Query query = entityManager.createNativeQuery(
                    "INSERT INTO has_spell (user_name, spell_id) VALUES (?, ?)");
        query.setParameter(1,name);
        query.setParameter(2,spellID);
        query.executeUpdate();
    }
}
