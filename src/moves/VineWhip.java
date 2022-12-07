package src.moves;

import java.util.List;

import src.moves.moveLogic.Move;
import src.moves.moveLogic.MovePhysical;
import src.pokemon.Type;

public class VineWhip extends MovePhysical {

    static List<Type> types = List.of(Type.GRASS);
    static int power = 45;
    static int ppMax = 25;

    @Override
    public Move getInstance() {
        return new VineWhip();
    }
}
