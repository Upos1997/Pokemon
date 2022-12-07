package src.combat.action;

import src.combat.field.Field;

public class MoveActionChangeHp extends ActionTargeted{
    public MoveActionChangeHp(MoveActionSingle action, int change) {
        super(action.user, action, action.target);
        this.change = change;
    }

    int change;

    public boolean isHeal(){
        return change < 0;
    }
    public boolean isDamage() {
        return change > 0;
    }

    @Override
    public Boolean action(Field field) {
        return (Boolean) super.action(field);
    }

    @Override
    public Boolean takeAction(Field field) {
        target.changeHp(change);
        return true;
    }
}
