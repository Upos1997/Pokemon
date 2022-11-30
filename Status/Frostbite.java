package Status;

import java.util.function.Predicate;

import action.ActionStaticDamage;
import action.MoveAction;
import action.Reaction;
import action.actionLogic.MessageAction;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;

public class Frostbite extends Status {
    Frostbite(Pokemon afflicted) {
        super(afflicted);
    }

    static private float damageMod = 0.5f;
    static private float frostDamage = 1 / 16;

    @Override
    protected void afflict(Field field) {
        Predicate<Field> predicate = _field -> {
            MoveAction action = (MoveAction) field.getCurrentAction();
            return action.getUser().hasStatus(StatusName.FROSTBITE) && action.getSource().isSpecial();
        };
        Modifier damageReduction = new Modifier(MessageModifier.POWER, damageMod, predicate);
        addModifier(field, damageReduction);
        Predicate<Field> dealDamage = _field -> {
            int damage = (int) (afflicted.getHpMax() * frostDamage * -1);
            return new ActionStaticDamage(afflicted, this, afflicted, damage).takeAction(field);
        };
        Reaction eotDamage = new Reaction(MessageAction.ROUND_END, afflicted, this, afflicted, Reaction.noCheck,
                dealDamage);
        addReaction(field, eotDamage);
    }

    @Override
    public Status getInstance(Pokemon pokemon) {
        return new Frostbite(pokemon);
    }
}
