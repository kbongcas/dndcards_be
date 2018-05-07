package com.kb.dndchar.managers;

import com.kb.dndchar.views.ViewSpell;

import javax.swing.text.View;
import java.util.List;

public interface ISpellManager {

    //ViewSpell getSpellById(Long spellId);
    ViewSpell updateSpell(Long spellId, ViewSpell viewSpell);
    ViewSpell deleteSpell(Long spellId);
    List<ViewSpell> getSpellName(String name);
    List<ViewSpell>  getAllSpellsOfUser(String username);
    ViewSpell createSpellForUser(String name, ViewSpell viewSpell);
    ViewSpell getSpellById(Long spellId, String name);
}
