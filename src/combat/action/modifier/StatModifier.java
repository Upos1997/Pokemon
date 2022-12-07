package src.combat.action.modifier;

import src.combat.action.Action;
import src.combat.action.reaction.ReactionPokemon;
import src.combat.field.SingleField;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class StatModifier extends Modifier {
    StatModifier(Pokemon user, Object source, Stat stat, float modifier, BiFunction<SingleField, Action, Boolean> check) {
        super(user, source, modifier, check, Modifier.noAction);
        this.stat = stat;
    }

    Stat stat;
    Pokemon target;

    public Stat getStat(){
        return stat;
    }

    public boolean check(SingleField field, ReactionPokemon action) {
        if (super.check(field, action)){
            target = action.getUser();
            return true;
        } else return false;
    }

    public void undo(){
        target.modStat(stat, 1/modifier);
    }
    static public Predicate<SingleField> makeAction(Pokemon target, Stat stat, float mod) {
        return (field_) -> {
            target.modStat(stat, mod);
            return true;
        };
    }
}
