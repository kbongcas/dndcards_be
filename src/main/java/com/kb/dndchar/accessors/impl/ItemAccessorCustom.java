package com.kb.dndchar.accessors.impl;

import com.kb.dndchar.accessors.IItemAccessorCustom;
import com.kb.dndchar.domains.DomainItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemAccessorCustom implements IItemAccessorCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public List<DomainItem> getItemsOfUser(String name) {
        Query query = entityManager.createNativeQuery(
                    "SELECT *\n" +
                        "FROM HAS_ITEM NATURAL JOIN ITEMS as S\n" +
                        "WHERE user_name = ?",
        DomainItem.class);
        query.setParameter(1,name);

        @SuppressWarnings("unchecked")
        List<DomainItem> spellList = query.getResultList();

        return spellList;
    }
}

