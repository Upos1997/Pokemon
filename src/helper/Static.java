package src.helper;

import src.ReactionPool.hasReactionPool;
import src.combat.action.modifier.Modifier;
import src.combat.action.prevent.Prevent;
import src.combat.action.reaction.Reaction;
import src.combat.field.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Static {
    private Map<hasReactionPool, List<Reaction>> reactions = new HashMap<>();
    private Map<hasReactionPool, List<Modifier>> modifiers = new HashMap<>();
    private Map<hasReactionPool, List<Prevent>> prevents = new HashMap<>();

    private void addRea(hasReactionPool has, Reaction reaction){
        List<Reaction> list = reactions.get(has);
        if (list == null){
            list = new ArrayList<>();
            list.add(reaction);
            reactions.put(has, list);
        } else {
            list.add(reaction);
        }
    }

    private void addMod(hasReactionPool has, Modifier modifier){
        List<Modifier> list = modifiers.get(has);
        if (list == null){
            list = new ArrayList<>();
            list.add(modifier);
            modifiers.put(has, list);
        } else {
            list.add(modifier);
        }
    }

    private void addPre(hasReactionPool has, Prevent prevent){
        List<Prevent> list = prevents.get(has);
        if (list == null){
            list = new ArrayList<>();
            list.add(prevent);
            prevents.put(has, list);
        } else {
            list.add(prevent);
        }
    }

    protected void addReaction(hasReactionPool has, Reaction reaction) {
        addRea(has, reaction);
        has.addReaction(reaction);
    }

    protected void addModifier(hasReactionPool has, Modifier modifier) {
        addMod(has, modifier);
        has.addModifier(modifier);
    }

    protected void addPrevent(hasReactionPool has, Prevent prevent) {
        addPre(has, prevent);
        has.addPrevent(prevent);
    }

    protected void clearEffects(Field field) {
        reactions.forEach((has, reactionList) -> reactionList.forEach(has::removeReaction));
        modifiers.forEach((has, modifierList) -> modifierList.forEach(has::removeModifier));
        prevents.forEach((has, preventList) -> preventList.forEach(has::removePrevent));
        reactions = new HashMap<>();
        modifiers = new HashMap<>();
        prevents = new HashMap<>();
    }
}
