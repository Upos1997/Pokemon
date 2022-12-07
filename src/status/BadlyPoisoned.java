package src.status;

import java.util.function.Predicate;


import combat.action.ActionStaticDamage;
import src.combat.action.reaction.Reaction;
import combat.action.actionLogic.MessageAction;
import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public class BadlyPoisoned extends Status {
    BadlyPoisoned(Pokemon afflicted) {
        super(afflicted);
    }

    static protected float basePoisonDamage = 1 / 16;
    protected float poisonDamage = basePoisonDamage;

    protected void updatePoison() {
        poisonDamage += basePoisonDamage;
    }

    @Override
    protected void afflict(SingleField field) {
        Predicate<SingleField> dealDamage = _field -> {
            int damage = (int) (afflicted.getHpMax() * poisonDamage * -1);
            new ActionStaticDamage(afflicted, this, afflicted, damage).takeAction(field);
            updatePoison();
            return true;
        };
        Reaction eotDamage = new Reaction(MessageAction.ROUND_END, afflicted, this, afflicted, Reaction.noCheck,
                dealDamage);
        addReaction(field, eotDamage);

    }

    @Override
    public void switchOut(SingleField field) {
        super.switchOut(field);
        poisonDamage = basePoisonDamage;
    }

    @Override
    public BadlyPoisoned getInstance(Pokemon pokemon) {
        return new BadlyPoisoned(pokemon);
    }
}
