package action;

import java.util.List;

import action.actionLogic.MoveAction;
import field.Field;
import helper.Rng;
import modifier.MessageModifier;
import modifier.Modifier;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Stat;
import prevent.MessagePrevent;

public class ActionHit extends MoveAction {

    public ActionHit(Pokemon user, Move move, Pokemon target) {
        super(user, move, target, List.of(MessagePrevent.HIT));
    }

    private double accuracyMod = Stat.getAccMod(user.getStage(Stat.ACCURACY), target.getStage(Stat.EVASION));
    private double accuracy = getSource().getAccuracy();

    @Override
    protected boolean action(Field field) {
        if (field.hasModifier(MessageModifier.AUTO_MISS)) {
            return false;
        } else if (getSource().isAutoHit() || field.hasModifier(MessageModifier.AUTO_HIT)) {
            return true;
        } else {
            for (Modifier modifier : field.getModifiers(MessageModifier.ACCURACY)) {
                accuracy *= modifier.getmodifier();
            }
            return Rng.chance(accuracy * accuracyMod);
        }
    }
}
