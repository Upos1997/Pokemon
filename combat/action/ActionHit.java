package combat.action;

import java.util.List;

import combat.action.actionLogic.Action;
import combat.field.Field;
import combat.modifier.MessageModifier;
import combat.prevent.MessagePrevent;
import helper.Rng;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Stat;

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
            double accuracyMod = Stat.getAccMod(user.getStage(Stat.ACC), target.getStage(Stat.EVA));
            double accuracy = doubleAdjustedValue(field, move.getAccuracy(), MessageModifier.ACCURACY);
            return Rng.chance(accuracy * accuracyMod);
        }
    }
}
