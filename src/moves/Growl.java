package src.moves;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.action.MoveAction.MoveActionChangeStage;
import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.moves.moveLogic.moveStatus;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;
import src.types.Normal;

public class Growl extends moveStatus {
    private Growl(){
        types = List.of(Normal.getInstance());
        ppMax = 40;
    }

    @Override
    public boolean isSound() {
        return true;
    }

    @Override
    protected void secondaryEffect(Field field, ActionMoveStatus action, Pokemon target) {
        new MoveActionChangeStage(action.getSelf(), action, target, Stat.ATK, -1);
    }

    static private final Growl growl = new Growl();

    static public Move getInstance() {
        return growl;
    }
}
