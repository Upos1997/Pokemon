package src.moves.moveLogic;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionMoveStatus;
import src.combat.action.MoveAction.MoveActionDamage;
import src.combat.field.Field;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.List;

public abstract class MoveDamaging extends Move {

    protected Stat attack;
    protected Stat defense;
    protected int power;

    public Stat getAttack() {
        return attack;
    }

    public Stat getDefense() {
        return defense;
    }

    public int getPower() {
        return power;
    }

    protected boolean secondaryEffect(Field field, ActionMoveDamaging action, Pokemon target){
        return true;
    }

    @Override
    public boolean use(Field field, Pokemon user, List<Pokemon> pokemons) {
        return true;
    }

    @Override
    public boolean singleTarget(Field field, ActionMoveStatus action, Pokemon target) {
        if (action instanceof ActionMoveDamaging action1) {
            int damage = new MoveActionDamage(action1, target).action(field);
            if (new MoveActionDealDamage(action1, target, damage).action(field)) {
                return secondaryEffect(field, action1, target);
            } else return false;
        } else return false;
    }
}
