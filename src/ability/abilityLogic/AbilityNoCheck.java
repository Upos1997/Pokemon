package src.ability.abilityLogic;

import java.util.function.Predicate;

import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public abstract class AbilityNoCheck extends Ability {

    AbilityNoCheck(Pokemon user) {
        super(user);
    }

    static protected Predicate<SingleField> isActive = field -> true;

}
