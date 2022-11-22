package moves;

import java.util.List;

import field.Field;
import moves.moveLogic.moveStatus;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;

public class Growl extends moveStatus{

    List<Type> types = List.of(Type.NORMAL);
    int ppMax = 40;
    int ppCurrent = 40;

    @Override
    protected void onHit(Field field, Pokemon user, Pokemon target) {
       target.lowered(Stat.ATTACK, 1); 
    }  
}
