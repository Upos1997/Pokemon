package src.status;

import java.util.function.Predicate;

import combat.action.actionLogic.Action;
import src.combat.field.SingleField;
import combat.modifier.MessageModifier;
import combat.modifier.Modifier;
import combat.prevent.MessagePrevent;
import combat.prevent.Prevent;
import src.helper.Rng;
import src.pokemon.Pokemon;

public class Drowsy extends Status {
    Drowsy(Pokemon afflicted) {
        super(afflicted);
    }

    static private float movePreventOdds = 1 / 3;
    static private float damageIncrease = 4 / 3;

    @Override
    protected void afflict(SingleField field) {
        Predicate<SingleField> predicate = _field -> {
            Action action = _field.getCurrentAction();
            if (action.getUser().hasStatus(StatusName.DROWSY)) {
                return Rng.chance(movePreventOdds);
            } else
                return false;
        };
        Prevent movePrevent = new Prevent(MessagePrevent.MOVE, predicate);
        addPrevent(field, movePrevent);
        Predicate<SingleField> check = _field -> {
            Action action = _field.getCurrentAction();
            return action.getUser().hasStatus(StatusName.DROWSY);
        };
        Modifier increasedDamage = new Modifier(MessageModifier.DAMAGE, damageIncrease, check);
        addModifier(field, increasedDamage);
    }

    @Override
    public Drowsy getInstance(Pokemon pokemon) {
        return new Drowsy(pokemon);
    }
}
