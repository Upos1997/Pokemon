package src.combat.action.modifier;

import src.combat.field.Field;

public interface Modifiable {
    default void getModifiers(Field field){
        field.applyModifiers(this);
    }
}
