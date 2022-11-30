package moves;

import java.util.List;

import moves.moveLogic.MovePhysical;
import pokemon.Type;

public class Tackle extends MovePhysical {

    static List<Type> types = List.of(Type.NORMAL);
    static int power = 40;
    static int ppMax = 35;
}
