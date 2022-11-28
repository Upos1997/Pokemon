package moves;

import java.util.List;
import java.util.function.BiFunction;

import action.actionLogic.Action;
import field.Field;
import moves.moveLogic.moveStatus;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;
import prevent.MessagePrevent;

public class Growl extends moveStatus {

    List<Type> types = List.of(Type.NORMAL);
    int ppMax = 40;
    int ppCurrent = 40;

    @Override
    protected BiFunction<Field, Action, Void> makeFunction(Pokemon user, Pokemon target) {
        return (field, action) -> {
            if (field.isAllowed(action, MessagePrevent.LOWER_ATTACK)) {
                target.lowered(Stat.ATTACK, 1);
            }
            return null;
        };
    }
}
