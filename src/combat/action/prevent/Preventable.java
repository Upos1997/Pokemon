package src.combat.action.prevent;

import src.combat.field.Field;

public interface Preventable {
    default boolean isAllowed(Field field){
        return field.isAllowed(this);
    }
}
