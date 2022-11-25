package Status;

import java.util.List;

import action.ActionMove;
import action.Reaction;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierMove;
import pokemon.Pokemon;

public class Frostbite extends Status {
    static private Modifier damageReduction = new ModifierMove(MessageModifier.POWER, 0.5f, (field) -> {
        ActionMove action = (ActionMove) field.getCurrentAction();
        Pokemon user = action.getUser();
        return user.hasStatus(StatusName.FROSTBITE) && action.isSpecial();
    });
    private Reaction eotDamage = new Reaction(pokemon, Reaction.noCheck, (field) -> {
        int damage = pokemon.getHpMax() / -16;
        pokemon.changeHp(damage);
        return null;
    });

    protected List<Modifier> modifiers = List.of(damageReduction);
    protected List<Reaction> reactions = List.of(eotDamage);
}
