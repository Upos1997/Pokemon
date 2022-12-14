package src.moves.moveLogic;

import src.combat.action.ActionMoveStatus;
import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class moveStatus extends Move {

    @Override
    public boolean makesContact(){
        return false;
    }

    @Override
    public boolean isStatus() {
        return true;
    }

    @Override
    protected boolean singleTarget(Field field, ActionMoveStatus action, Pokemon target) {
        if (super.singleTarget(field, action, target)){
            secondaryEffect(field, action, target);
            return true;
        } else {
            return false;
        }
    }
}
