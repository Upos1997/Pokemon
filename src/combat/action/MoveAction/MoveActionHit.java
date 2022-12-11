package src.combat.action.MoveAction;

import src.combat.action.ActionMoveStatus;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

public class MoveActionHit extends ActionTargeted<Boolean> {
    public MoveActionHit(ActionMoveStatus source, Pokemon target) {
        super(source.getSelf(), source, target);
        this.move = source.getSource();
        this.accuracy = move.getAccuracy();
        this.autoHit = move.isAutoHit();
    }

    Move move;
    double accuracy;
    boolean autoHit;

    @Override
    protected Boolean takeAction(Field field) {
        return autoHit || Rng.chance(accuracy* Stat.getAccMod(self.getStage(Stat.ACC), target.getStage(Stat.EVA)));
    }
}
