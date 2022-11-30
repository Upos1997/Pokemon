package Status;

import java.util.function.Predicate;

import action.actionLogic.Action;
import field.Field;
import helper.Rng;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.MessagePrevent;
import prevent.Prevent;

public class Drowsy extends Status {
    Drowsy(Pokemon afflicted) {
        super(afflicted);
    }

    static private float movePreventOdds = 1 / 3;
    static private float damageIncrease = 4 / 3;

    @Override
    protected void afflict(Field field) {
        Predicate<Field> predicate = _field -> {
            Action action = _field.getCurrentAction();
            if (action.getUser().hasStatus(StatusName.DROWSY)) {
                return Rng.chance(movePreventOdds);
            } else
                return false;
        };
        Prevent movePrevent = new Prevent(MessagePrevent.MOVE, predicate);
        addPrevent(field, movePrevent);
        Predicate<Field> check = _field -> {
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
