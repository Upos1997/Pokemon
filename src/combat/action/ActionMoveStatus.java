package src.combat.action;

import src.combat.field.Field;
import src.combat.field.Slot;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.Type;

import java.util.List;

public class ActionMoveStatus extends Action<Boolean> {
    ActionMoveStatus(Pokemon user, Move source, List<Slot> targets) {
        super(user, source);
        this.targets = targets;
        this.types = source.getTypes();
        this.priority = source.getPriority();
        this.accuracy = source.getAccuracy();
        this.autoHit = source.isAutoHit();
        this.baseValue = false;
    }
    List<Slot> targets;

    @Override
    public Move getSource() {
        return (Move) source;
    }

    public List<Type> types;
    public int priority;
    public float accuracy;
    public boolean autoHit;

    @Override
    public Boolean takeAction(Field field) {
        return getSource().use(field, self, targets.stream().map(Slot::getPokemon).toList());
    }
}
