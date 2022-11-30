package ability.abilityLogic;

import java.util.function.Predicate;

import field.Field;
import pokemon.Pokemon;

public abstract class AbilityNoCheck extends Ability {

    AbilityNoCheck(Pokemon user) {
        super(user);
    }

    static protected Predicate<Field> isActive = field -> true;

}
