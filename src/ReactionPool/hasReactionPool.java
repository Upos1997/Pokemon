package src.ReactionPool;

import src.combat.action.Action;
import src.combat.action.modifier.Modifier;
import src.combat.action.prevent.Prevent;
import src.combat.action.reaction.Reaction;
import src.combat.field.Field;
import src.moves.moveLogic.MoveStat;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.List;

public interface hasReactionPool {
    ReactionPool getReactionPool();
    default void addReaction(Reaction reaction) {
        getReactionPool().add(reaction);
    }
    default void addModifier(Modifier modifier) {
        getReactionPool().add(modifier);
    }
    default void addPrevent(Prevent prevent) {
        getReactionPool().add(prevent);
    }
    default void removeReaction(Reaction reaction) {
        getReactionPool().remove(reaction);
    }
    default void removeModifier(Modifier modifier){
        getReactionPool().remove(modifier);
    }
    default void removePrevent(Prevent prevent){
        getReactionPool().remove(prevent);
    }
    default boolean isAllowed(Field field, Action action){
        return getReactionPool().isAllowed(field, action);
    }
    default void applyActionModifiers(Field field, Action action){
        getReactionPool().applyActionModifiers(field, action);
    }
    default void applyStatModifiers(Field field, Pokemon target){
        getReactionPool().applyStatModifiers(field, target);
    }
    default void handleReactions(Field field, Action action){
        getReactionPool().handleReactions(field, action);
    }
}
