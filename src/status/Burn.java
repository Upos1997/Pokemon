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

public class Burn extends Status {
    Burn(Pokemon afflicted) {
        super(afflicted);
    }

    static private double damageMod = 0.5;
    static private double burnDamage = 1 / 16;

    @Override
    protected void afflict(SingleField field) {
        Predicate<SingleField> check = _field -> {
            MoveAction action = (MoveAction) _field.getCurrentAction();
            return action.getSource().isPhysical() && action.getUser().equals(afflicted);
        };
        Modifier damageReduction = new Modifier(MessageModifier.DAMAGE, damageMod, check);
        addModifier(field, damageReduction);
        Predicate<SingleField> dealDamage = _field -> {
            int damage = (int) (afflicted.getHpMax() * burnDamage * -1);
            return new ActionStaticDamage(afflicted, this, afflicted, damage).takeAction(field);
        };
        Reaction eotDamage = new Reaction(MessageAction.ROUND_END, afflicted, this, afflicted, Reaction.noCheck,
                dealDamage);
        addReaction(field, eotDamage);
    }

    @Override
    public Burn getInstance(Pokemon pokemon) {
        return new Burn(pokemon);
    }
}
