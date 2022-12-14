package src.moves;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.action.MoveAction.MoveActionChangeStage;
import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.moves.moveLogic.moveStatus;
import src.pokemon.Pokemon;
import src.pokemon.Stat;
import src.pokemon.Type;

public class Growl extends moveStatus {
    private Growl(){
        types = List.of(Type.NORMAL);
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

    @Override
    public static Move getInstance() {
        return growl;
    }
}
