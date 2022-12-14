package src.combat.action.MoveAction;

import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;

public class MoveActionChangeStage extends ActionTargeted<Boolean> {
    public MoveActionChangeStage(Pokemon self, Source source, Pokemon target, Stat stat, int stages) {
        super(self, source, target);
        this.stat = stat;
        this.stages = stages;
        this.baseValue = false;
    }

    public Stat stat;
    public int stages;

    public boolean isLowers(){
        return stages < 0;
    }
    public boolean isRaises(){
        return !isLowers();
    }

    @Override
    protected Boolean takeAction(Field field) {
        target.updateStages(stat, stages);
        return true;
    }
}
