package Status;

import java.util.List;

import helper.Rng;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierStat;
import pokemon.Pokemon;
import prevent.MessagePrevent;
import prevent.Prevent;

public class Paralysis extends Status {
    static private double speedMod = 0.5;
    static private double movePreventOdds = 0.25;
    static private Modifier speedReduction = new ModifierStat(MessageModifier.SPEED, speedMod, (field, pokemon) -> {
        return pokemon.hasStatus(StatusName.PARALYSIS);
    });
    static private Prevent movePrevent = new Prevent(MessagePrevent.MOVE, (field) -> {
        Pokemon user = field.getCurrentAction().getUser();
        return user.hasStatus(StatusName.PARALYSIS) && Rng.chance(movePreventOdds);
    });

    static protected List<Modifier> modifiers = List.of(speedReduction);
    static protected List<Prevent> prevents = List.of(movePrevent);
}
