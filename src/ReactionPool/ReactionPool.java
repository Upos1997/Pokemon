package src.ReactionPool;

import src.combat.action.modifier.Modifiable;
import src.combat.action.modifier.Modifier;
import src.combat.action.prevent.Prevent;
import src.combat.action.prevent.Preventable;
import src.combat.action.reaction.Reaction;
import src.combat.action.reaction.Reactionable;
import src.combat.field.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReactionPool {
    Map<Class<?>, List<Prevent>> prevents = new HashMap<>();
    Map<Class<?>, List<Modifier>> modifiers = new HashMap<>();
    Map<Class<?>, List<Reaction>> reactions = new HashMap<>();

    public boolean isAllowed(Field field, Preventable preventable){
        return prevents.get(preventable.getClass()).stream().filter(prevent -> prevent.use(field, preventable)).noneMatch(prevent -> isAllowed(field, prevent));
    }

    public void applyModifiers(Field field, Modifiable modifiable){
        modifiers.get(modifiable.getClass()).forEach(modifier -> modifier.use(field, modifiable));
    }

    public void handleReactions(Field field, Reactionable reactionable){
        reactions.get(reactionable.getClass()).forEach(reaction -> reaction.use(field, reactionable));
    }

    public void addReaction(Reaction reaction){
        List<Reaction> list = reactions.computeIfAbsent(reaction.getClassCheck(), k -> new ArrayList<>());
        list.add(reaction);
    }

    public void addModifier(Modifier modifier){
        List<Modifier> list = modifiers.computeIfAbsent(modifier.getClassCheck(), k -> new ArrayList<>());
        list.add(modifier);
    }

    public void addPrevent(Prevent prevent){
        List<Prevent> list = prevents.computeIfAbsent(prevent.getClassCheck(), k -> new ArrayList<>());
        list.add(prevent);
    }

    public void removeReaction(Reaction reaction){
        Class<?> classCheck = reaction.getClassCheck();
        List<Reaction> list = reactions.get(classCheck);
        list.remove(reaction);
        if (list.isEmpty()){
            reactions.remove(classCheck);
        }
    }

    public void removeModifier(Modifier modifier){
        Class<?> classCheck = modifier.getClassCheck();
        List<Modifier> list = modifiers.get(classCheck);
        list.remove(modifier);
        if (list.isEmpty()){
            modifiers.remove(classCheck);
        }
    }

    public void removePrevent(Prevent prevent){
        Class<?> classCheck = prevent.getClassCheck();
        List<Prevent> list = prevents.get(classCheck);
        list.remove(prevent);
        if (list.isEmpty()){
            prevents.remove(classCheck);
        }
    }
}
