package src.combat.action.MoveAction;

import src.combat.action.ActionMoveStatus;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.pokemon.Pokemon;

public class MoveActionChangeHp extends ActionTargeted<Boolean> {
    public MoveActionChangeHp(ActionMoveStatus action, Pokemon target, int damage){
        super(action.getSelf(), action, target);
        this.damage = damage;
    }

    public int damage;

    @Override
    public ActionMoveStatus getSource() {
        return (ActionMoveStatus) source;
    }

    @Override
    protected Boolean takeAction(Field field) {
        target.changeHp(damage * -1);
        return true;
    }
}
