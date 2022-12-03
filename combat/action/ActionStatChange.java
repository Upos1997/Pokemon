package combat.action;

import java.util.List;

import combat.action.actionLogic.Action;
import combat.field.Field;
import combat.modifier.MessageModifier;
import combat.prevent.MessagePrevent;
import pokemon.Pokemon;
import pokemon.Stat;

public class ActionStatChange extends Action {

    public ActionStatChange(Pokemon user, Object source, Pokemon target, Stat stat, int stages) {
        super(user, source, target);
        this.stat = stat;
        this.stages = stages;
    }

    protected Stat stat;
    protected int stages;
    protected List<MessagePrevent> messages = List.of(MessagePrevent.CHANGE_STAT);

    public Stat getStat() {
        return stat;
    }

    public int getStages() {
        return stages;
    }

    @Override
    protected boolean action(Field field) {
        int stages = (int) doubleAdjustedValue(field, this.stages, MessageModifier.CHANGE_STAT);
        if (stages > 0) {
            target.wentUp(stat, stages);
        } else {
            target.lowered(stat, stages);
        }
        return true;
    }

}
