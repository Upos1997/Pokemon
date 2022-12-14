package src.moves;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.moves.moveLogic.MovePhysical;
import src.pokemon.Pokemon;
import src.pokemon.enums.Type;

public class VineWhip extends MovePhysical {
    private VineWhip(){
        super();
        types = List.of(Type.GRASS);
        power = 45;
        ppMax = 25;
    }

    @Override
    protected void secondaryEffect(Field field, ActionMoveStatus action, Pokemon target) {}

    static private final VineWhip vineWhip = new VineWhip();

    public static Move getInstance() {
        return vineWhip;
    }
}
