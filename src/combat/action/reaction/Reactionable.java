package src.combat.action.reaction;

import src.combat.field.Field;

public interface Reactionable {
    default void handleReactions(Field field){
        field.handleReactions(this);
    }
}
