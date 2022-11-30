package moves;

import java.util.List;

import moves.moveLogic.MovePhysical;
import pokemon.Type;

public class VineWhip extends MovePhysical {

    static List<Type> types = List.of(Type.GRASS);
    static int power = 45;
    static int ppMax = 25;
}
