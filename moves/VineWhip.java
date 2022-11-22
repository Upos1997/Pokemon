package moves;

import java.util.List;

import field.Field;
import moves.moveLogic.MovePhysical;
import pokemon.Pokemon;
import pokemon.Type;

public class VineWhip extends MovePhysical{

    static List<Type> types = List.of(Type.GRASS);
    static int ppMax = 25;
    static int ppCurrent = 25;

    @Override
    protected void onHit(Field field, Pokemon user, Pokemon target) {
        dealDamage(field, user, target);  
    }
    
}
