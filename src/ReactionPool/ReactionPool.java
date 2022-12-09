package src.ReactionPool;

import src.combat.action.*;
import src.combat.action.modifier.*;
import src.combat.action.prevent.Prevent;
import src.combat.action.reaction.Reaction;
import src.combat.action.reaction.ReactionPokemon;
import src.combat.field.Field;
import src.moves.moveLogic.MoveStat;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.ArrayList;
import java.util.List;

public class ReactionPool {
    List<Prevent> prevents = new ArrayList<>();
    List<Modifier> modifiers = new ArrayList<>();
    List<Reaction> reactions = new ArrayList<>();

    public boolean isAllowed(Field field, Action action){
        return prevents.stream().filter(prevent -> prevent.checkThenUse(field, action)).noneMatch(prevent -> isAllowed(field, prevent));
    }

    public void applyActionModifiers(Field field, Action action){
        modifiers.stream().filter(modifier -> modifier instanceof MoveModifier).forEach(modifier -> modifier.checkThenUse(field, action));
    }

    public void applyStatModifiers(Field field, Pokemon target){
        Action action = new ReactionPokemon(target, target);
        modifiers.stream().filter(modifier -> modifier instanceof StatModifier).forEach(modifier -> modifier.checkThenUse(field, action));
    }

    public void handleReactions(Field field, Action action){
        reactions.forEach(reaction -> reaction.checkThenUse(field, action));
    }

    public void add(Reaction reaction){
        if (reaction instanceof Prevent){
            prevents.add((Prevent) reaction);
        } else if (reaction instanceof Modifier){
            modifiers.add((Modifier) reaction);
        } else {
            reactions.add(reaction);
        }
    }

    public void remove(Reaction reaction){
        if (reaction instanceof Prevent){
            prevents.remove(reaction);
        } else if (reaction instanceof Modifier){
            modifiers.remove(reaction);
        } else {
            reactions.remove(reaction);
        }
    }
}
