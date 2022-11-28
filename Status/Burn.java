package Status;

import java.util.List;
import java.util.function.Function;

import action.Reaction;
import action.actionLogic.ActionMove;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;

public class Burn extends Status {
    static private double damageMod = 0.5;
    static private double burnDamage = 1 / 16;

    static private Modifier makedamageReduction(Pokemon pokemon) {
        MessageModifier message = MessageModifier.POWER;
        Function<Field, Boolean> check = (field) -> {
            ActionMove action = (ActionMove) field.getCurrentAction();
            Pokemon user = action.getUser();
            return user.equals(pokemon) && action.isPhysical();
        };
        return new Modifier(message, damageMod, check);
    }

    static private Reaction makeEoTDamage(Pokemon pokemon) {

    }

    private Reaction eotDamage = new Reaction(pokemon, Reaction.noCheck, (field) -> {
        int damage = (int) (pokemon.getHpMax() * -burnDamage);
        pokemon.changeHp(damage);
        return null;
    });

    static protected List<Modifier> modifiers = List.of(damageReduction);
    protected List<Reaction> reactions = List.of(eotDamage);
}
