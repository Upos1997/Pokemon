package Status;

import action.actionLogic.ActionMove;
import helper.Rng;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierMove;
import pokemon.Pokemon;
import prevent.MessagePrevent;
import prevent.Prevent;

public class Drowsy extends Status {
    static private double movePreventOdds = 0.5;
    static private Prevent movePrevent = new Prevent(MessagePrevent.MOVE, (field) -> {
        Pokemon user = field.getCurrsentAction().getUser();
        return user.hasStatus(StatusName.DROWSY) && Rng.chance(movePreventOdds);
    });
    static private Modifier damageIncrease = new ModifierMove(MessageModifier.POWER, 1.5, (field) -> {
        ActionMove action = (ActionMove) field.getCurrentAction();
        Pokemon target = action.get
    })

}
