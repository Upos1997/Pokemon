package action;

import java.util.List;

import action.actionLogic.Action;
import field.Field;
import helper.Rng;
import modifier.MessageModifier;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Stat;
import prevent.MessagePrevent;

public class ActionHit extends Action {

    public ActionHit(Pokemon user, Move move, Pokemon target) {
        super(user, move, target);
    }

    @Override
    public Move getSource() {
        return (Move) source;
    }

    static List<MessagePrevent> messages = List.of(MessagePrevent.HIT);

    @Override
    protected boolean action(Field field) {
        Move move = getSource();
        if (move.isAutoHit() || field.hasModifier(MessageModifier.AUTO_HIT)) {
            return true;
        } else {
            double accuracyMod = Stat.getAccMod(user.getStage(Stat.ACCURACY), target.getStage(Stat.EVASION));
            double accuracy = doubleAdjustedValue(field, move.getAccuracy(), MessageModifier.ACCURACY);
            return Rng.chance(accuracy * accuracyMod);
        }
    }
}
