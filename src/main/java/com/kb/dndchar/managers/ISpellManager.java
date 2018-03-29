package com.kb.dndchar.managers;

import com.kb.dndchar.views.ViewSpell;

import javax.swing.text.View;
import java.util.List;

public interface ISpellManager {
    List<ViewSpell> getAllSpells();
    ViewSpell getSpellById(Long spellId);
    List<ViewSpell> getSpellsByCharId( Long charId);
    ViewSpell createSpell(ViewSpell viewSpell);
    ViewSpell updateSpell(Long spellId, ViewSpell viewSpell);
    ViewSpell deleteSpell(Long spellId);
}
