package src.ReactionPool;

import src.combat.action.modifier.Modifiable;
import src.combat.action.modifier.Modifier;
import src.combat.action.prevent.Prevent;
import src.combat.action.prevent.Preventable;
import src.combat.action.reaction.Reaction;
import src.combat.action.reaction.Reactionable;
import src.combat.field.Field;

public interface hasReactionPool {
    ReactionPool getReactionPool();
    default void addReaction(Reaction reaction) {
        getReactionPool().addReaction(reaction);
    }
    default void addModifier(Modifier modifier) {
        getReactionPool().addModifier(modifier);
    }
    default void addPrevent(Prevent prevent) {
        getReactionPool().addPrevent(prevent);
    }
    default void removeReaction(Reaction reaction) {
        getReactionPool().removeReaction(reaction);
    }
    default void removeModifier(Modifier modifier){
        getReactionPool().removeModifier(modifier);
    }
    default void removePrevent(Prevent prevent){
        getReactionPool().removePrevent(prevent);
    }
    default boolean isAllowed(Field field, Preventable preventable){
        return getReactionPool().isAllowed(field, preventable);
    }
    default void applyModifiers(Field field, Modifiable modifiable){
        getReactionPool().applyModifiers(field, modifiable);
    }
    default void handleReactions(Field field, Reactionable reactionable){
        getReactionPool().handleReactions(field, reactionable);
    }
}
