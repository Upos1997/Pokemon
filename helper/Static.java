package helper;

import combat.action.Reaction;
import combat.field.Field;
import combat.modifier.Modifier;
import combat.prevent.Prevent;

import java.util.ArrayList;
import java.util.List;


public abstract class Static {
    protected List<Reaction> reactions = new ArrayList<>();
    protected List<Modifier> modifiers = new ArrayList<>();
    protected List<Prevent> prevents = new ArrayList<>();

    protected void addReaction(Field field, Reaction reaction) {
        reactions.add(reaction);
        field.addReaction(reaction);
    }

    protected void addModifier(Field field, Modifier modifier) {
        modifiers.add(modifier);
        field.addModifier(modifier);
    }

    protected void addPrevent(Field field, Prevent prevent) {
        prevents.add(prevent);
        field.addPrevent(prevent);
    }

    protected void clearEffects(Field field) {
        for (Reaction reaction : reactions) {
            field.removeReaction(reaction);
        }
        for (Modifier modifier : modifiers) {
            field.removeModifier(modifier);
        }
        for (Prevent prevent : prevents) {
            field.removePrevent(prevent);
        }
        reactions = new ArrayList<>();
        modifiers = new ArrayList<>();
        prevents = new ArrayList<>();
    }
}
