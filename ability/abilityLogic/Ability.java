package ability.abilityLogic;

import java.util.List;

import action.Reaction;
import field.Field;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.Prevent;

public abstract class Ability implements Cloneable {
    protected Pokemon user;

    abstract public Ability newInstance(Pokemon user);

    public void activate(Field field) {
        for (Modifier modifier : modifiers) {
            field.addModifier(modifier);
        }
        for (Prevent prevent : prevents) {
            field.addPrevent(prevent);
        }
        for (Reaction reaction : reactions) {
            field.addReaction(reaction);
        }
    }
}
