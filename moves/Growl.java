package moves;

import java.util.List;

import action.ActionStatChange;
import action.actionLogic.Action;
import moves.moveLogic.moveStatus;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;

public class Growl extends moveStatus {

    List<Type> types = List.of(Type.NORMAL);
    int ppMax = 40;
    int ppCurrent = 40;

    @Override
    protected List<Action> makeActions(Pokemon user, Pokemon target) {
        Action lowerAttack = new ActionStatChange(user, this, target, Stat.ATTACK, -1);
        return List.of(lowerAttack);
    }

}
