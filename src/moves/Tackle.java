package src.moves;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.moves.moveLogic.MovePhysical;
import src.pokemon.Pokemon;
import src.pokemon.Type;

public class Tackle extends MovePhysical {

    static List<Type> types = List.of(Type.NORMAL);
    static int power = 40;
    static int ppMax = 35;

    @Override
    public Move getInstance() {
        return new Tackle();
    }
}
