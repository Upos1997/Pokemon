package action;

import action.actionLogic.Action;
import field.Field;
import helper.Rng;
import modifier.MessageModifier;
import moves.moveLogic.MoveDamaging;
import pokemon.Pokemon;

public class ActionCrit extends Action {

    public ActionCrit(Pokemon user, MoveDamaging move, Pokemon target) {
        super(user, move, target);
    }

    @Override
    public MoveDamaging getSource() {
        return (MoveDamaging) source;
    }

    private double critChance = getSource().getCritChance();

    @Override
    protected boolean action(Field field) {
        if (field.hasModifier(MessageModifier.AUTO_CRIT)) {
            return true;
        } else {
            if (field.hasModifier(MessageModifier.CRIT_CHANCE1)) {
                critChance *= 4;
            }
            if (field.hasModifier(MessageModifier.CRIT_CHANCE2)) {
                critChance *= 8;
            }
            return Rng.chance(critChance);
        }
    }
}
