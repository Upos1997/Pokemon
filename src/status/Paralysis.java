package src.status;

import java.util.function.Predicate;


import src.combat.field.SingleField;
import combat.prevent.MessagePrevent;
import combat.prevent.Prevent;
import src.helper.Rng;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

public class Paralysis extends Status {
    Paralysis(Pokemon afflicted) {
        super(afflicted);
    }

    static private final float speedMod = 0.5f;
    static private final float movePreventOdds = 0.25f;

    @Override
    protected void afflict(SingleField field) {
        afflicted.modStat(Stat.SPE, speedMod);
        Predicate<SingleField> predicate = _field -> {
            Pokemon user = field.getCurrentAction().getUser();
            return user.hasStatus(StatusName.PARALYSIS) && Rng.chance(movePreventOdds);
        };
        Prevent movePrevent = new Prevent(MessagePrevent.MOVE, predicate);
        addPrevent(field, movePrevent);
    }

    @Override
    public void cure(SingleField field) {
        super.cure(field);
        afflicted.modStat(Stat.SPE, 1/speedMod);
    }

    @Override
    public Paralysis getInstance(Pokemon pokemon) {
        return new Paralysis(pokemon);
    }
}
