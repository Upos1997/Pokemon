package src.combat.action;

import src.combat.field.Field;
import src.combat.field.Slot;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.types.Type;

import java.util.List;

public class ActionMoveStatus extends Action<Void> {
    ActionMoveStatus(Pokemon user, Move source, List<Slot> targets) {
        super(user, source);
        this.targets = targets;
        this.types = source.getTypes();
        this.priority = source.getPriority();
        this.accuracy = source.getAccuracy();
        this.autoHit = source.isAutoHit();
        this.baseValue = null;
    }
    List<Slot> targets;

    public List<Slot> getTargets() {
        return targets;
    }

    @Override
    public Move getSource() {
        return (Move) source;
    }

    public List<Type> types;
    public int priority;
    public float accuracy;
    public boolean autoHit;

    @Override
    protected Void takeAction(Field field) {
        getSource().use(field, this);
        return null;
    }
}
