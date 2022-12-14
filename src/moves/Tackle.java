package src.moves;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.moves.moveLogic.MovePhysical;
import src.pokemon.Pokemon;
import src.pokemon.Type;

public class Tackle extends MovePhysical {
    private Tackle(){
        super();
        types = List.of(Type.NORMAL);
        power = 40;
        ppMax = 35;
    }

    @Override
    protected void secondaryEffect(Field field, ActionMoveStatus action, Pokemon target) {}

    static final private Tackle tackle = new Tackle();

    @Override
    public static Move getInstance() {
        return tackle;
    }
}
