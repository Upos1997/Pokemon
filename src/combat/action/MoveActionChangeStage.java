package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Stat;

public class MoveActionChangeStage extends  ActionTargeted{
    public MoveActionChangeStage(Stat stat, int stages, MoveActionSingle parent) {
        super(parent.user, parent, parent.target);
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
