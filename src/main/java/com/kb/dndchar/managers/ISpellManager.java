package com.kb.dndchar.managers;

import com.kb.dndchar.views.ViewSpell;

import java.util.List;

public interface ISpellManager {
    List<ViewSpell> getAllSpells();
    ViewSpell getSpellById(Long spellId);
    List<ViewSpell> getSpellsByCharId( Long charId);
}
