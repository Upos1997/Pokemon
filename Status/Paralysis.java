package status;

import java.util.function.Predicate;


import combat.field.Field;
import combat.prevent.MessagePrevent;
import combat.prevent.Prevent;
import helper.Rng;
import pokemon.Pokemon;
import pokemon.Stat;

public class Paralysis extends Status {
    Paralysis(Pokemon afflicted) {
        super(afflicted);
    }

    static private final float speedMod = 0.5f;
    static private final float movePreventOdds = 0.25f;

    @Override
    protected void afflict(Field field) {
        afflicted.modStat(Stat.SPE, speedMod);
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
        afflicted.modStat(Stat.SPE, 1/speedMod);
    }

    @Override
    public Paralysis getInstance(Pokemon pokemon) {
        return new Paralysis(pokemon);
    }
}
