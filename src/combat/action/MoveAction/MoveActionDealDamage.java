package src.combat.action.MoveAction;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.pokemon.Pokemon;

public class MoveActionDealDamage extends ActionTargeted implements MoveActionDamaging{
    public MoveActionDealDamage(ActionMoveDamaging action, Pokemon target, int damage){
        super(action.getUser(), action, target);
        this.damage = damage;
    }

    public int damage;

    ActionMoveDamaging source;

    @Override
    public ActionMoveDamaging getSource() {
        return source;
    }

    @Override
    public Boolean action(Field field) {
        return super.action(field) instanceof Boolean;
    }

    @Override
    public Boolean takeAction(Field field) {
        target.changeHp(damage * -1);
        return true;
    }
}
