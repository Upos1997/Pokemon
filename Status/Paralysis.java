package status;

import java.util.function.Predicate;

import field.Field;
import helper.Rng;
import pokemon.Pokemon;
import pokemon.Stat;
import prevent.MessagePrevent;
import prevent.Prevent;

public class Paralysis extends Status {
    Paralysis(Pokemon afflicted) {
        super(afflicted);
    }

    static private float speedMod = 0.5f;
    static private float movePreventOdds = 0.25f;

    @Override
    protected void afflict(Field field) {
        afflicted.updateMod(Stat.SPEED, speedMod);
        Predicate<Field> predicate = _field -> {
            Pokemon user = field.getCurrentAction().getUser();
            return user.hasStatus(StatusName.PARALYSIS) && Rng.chance(movePreventOdds);
        };
        Prevent movePrevent = new Prevent(MessagePrevent.MOVE, predicate);
        addPrevent(field, movePrevent);
    }

    @Override
    public void cure(Field field) {
        super.cure(field);
        afflicted.updateMod(Stat.SPEED, 1 / speedMod);
    }

    @Override
    public Paralysis getInstance(Pokemon pokemon) {
        return new Paralysis(pokemon);
    }
}
