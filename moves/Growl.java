package moves;

import java.util.List;

import combat.action.ActionStatChange;
import combat.action.actionLogic.Action;
import moves.moveLogic.moveStatus;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;

public class Growl extends moveStatus {

    List<Type> types = List.of(Type.NORMAL);
    int ppMax = 40;

    @Override
    protected List<Action> makeActions(Pokemon user, Pokemon target) {
        Action lowerAttack = new ActionStatChange(user, this, target, Stat.ATK, -1);
        return List.of(lowerAttack);
    }

}
