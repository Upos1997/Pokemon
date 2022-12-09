package src.combat.action.MoveAction;

import src.combat.action.ActionMoveStatus;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

public class MoveActionChangeStage extends ActionTargeted implements MoveAction{
    public MoveActionChangeStage(ActionMoveStatus parent, Pokemon target, Stat stat, int stages) {
        super(parent.getUser(), parent, target);
        this.stat = stat;
        this.stages = stages;
    }

    public Stat stat;
    public int stages;

    public boolean isLowers(){
        return stages < 0;
    }
    public boolean isRaise(){
        return stages > 0;
    }

    @Override
    public Boolean action(Field field) {
        return (Boolean) super.action(field);
    }

    @Override
    public Boolean takeAction(Field field) {
        target.updateStages(stat, stages);
        return true;
    }
}
