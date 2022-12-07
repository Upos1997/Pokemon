package src.combat.action;

import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.Move;
import src.pokemon.Stat;

public class MoveActionHit extends ActionTargeted{
    MoveActionHit(MoveActionSingle source) {
        super(source.user, source, source.target);
        this.move = source.move;
        this.accuracy = move.getAccuracy();
        this.autoHit = move.isAutoHit();
    }

    Move move;
    double accuracy;
    boolean autoHit;

    @Override
    public Boolean action(Field field) {
        return (Boolean) super.action(field);
    }

    @Override
    public Boolean takeAction(Field field) {
        return autoHit || Rng.chance(accuracy* Stat.getAccMod(user.getStage(Stat.ACC), target.getStage(Stat.EVA)));
    }
}
