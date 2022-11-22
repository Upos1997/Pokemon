package ability;

import java.util.Collections;
import java.util.List;

import action.Reaction;
import field.Field;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.Prevent;

public abstract class Ability implements Cloneable{
    private List<Modifier> modifiers = Collections.emptyList();
    private List<Prevent> prevents = Collections.emptyList();
    private List<Reaction> reactions = Collections.emptyList();
    private Pokemon user;

    public Ability newInstance(Pokemon user){
        try {
            Ability newAbility = (Ability) super.clone();
            newAbility.user = user;
            return newAbility;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void activate(Field field){
        for (Modifier modifier: modifiers){
            field.addModifier(modifier)
        }
        for (Prevent prevent: prevents){
            field.addPrevent(prevent);
        }
        for (Reaction reaction: reactions){
            field.addReaction(reaction., reaction)
        }
    }
}
