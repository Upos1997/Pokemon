package moves;

import java.util.List;

import action.actionLogic.Action;
import moves.moveLogic.MovePhysical;
import pokemon.Pokemon;
import pokemon.Type;

public class Tackle extends MovePhysical {

    static List<Type> types = List.of(Type.NORMAL);
    static int power = 40;
    static int ppMax = 35;
    int ppCurrent = 35;

    @Override
    protected List<Action> makeActions(Pokemon user, Pokemon target) {

    }

}
