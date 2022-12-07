package src.status;

import java.util.function.Predicate;

import combat.action.ActionStaticDamage;
import src.combat.action.MoveAction;
import src.combat.action.reaction.Reaction;
import combat.action.actionLogic.MessageAction;
import src.combat.field.SingleField;
import combat.modifier.MessageModifier;
import combat.modifier.Modifier;
import src.pokemon.Pokemon;

public class Frostbite extends Status {
    Frostbite(Pokemon afflicted) {
        super(afflicted);
    }

    static private final float damageMod = 0.5f;
    static private final float frostDamage = 1/16f;

    @Override
    protected void afflict(SingleField field) {
        Predicate<SingleField> predicate = _field -> {
            MoveAction action = (MoveAction) field.getCurrentAction();
            return action.getUser().hasStatus(StatusName.FROSTBITE) && action.getSource().isSpecial();
        };
        Modifier damageReduction = new Modifier(MessageModifier.POWER, damageMod, predicate);
        addModifier(field, damageReduction);
        Predicate<SingleField> dealDamage = _field -> {
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
