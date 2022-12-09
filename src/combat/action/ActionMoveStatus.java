package src.combat.action;

import src.combat.action.MoveAction.MoveAction;
import src.combat.field.Field;
import src.combat.field.Slot;
import src.moves.moveLogic.MoveStat;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.Type;

import java.util.List;

public class ActionMoveStatus extends Action implements MoveAction {
    ActionMoveStatus(Pokemon user, Move source, List<Slot> targets) {
        super(user, source);
        this.targets = targets;
        this.types = source.getTypes();
        this.priority = source.getPriority();
        this.accuracy = source.getAccuracy();
        this.autoHit = source.isAutoHit();
    }

    protected List<MoveStat> mods = List.of(MoveStat.TYPE, MoveStat.PRIORITY, MoveStat.ACCURACY);
    Move source;
    List<Slot> targets;

    @Override
    public Move getSource() {
        return source;
    }

    public List<Type> types;
    public int priority;
    public float accuracy;
    public boolean autoHit;

    protected void applyActionModifiers(Field field){
        field.applyActionModifiers(this);
        user.applyActionModifiers(field, this);
    }

    @Override
    public Object takeAction(Field field) {
        applyActionModifiers(field);
        targets.stream().map(Slot::getPokemon).forEach(pokemon -> source.singleTarget(field, this, pokemon));
        return source.use(field, user);
    }

    @Override
    public List<Type> getTypes() {
        return types;
    }
    @Override
    public void setTypes(List<Type> types) {
        this.types = types;
    }
    @Override
    public int getPriority() {
        return priority;
    }
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public float getAccuracy() {
        return accuracy;
    }
    @Override
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
    @Override
    public boolean isAutoHit() {
        return autoHit;
    }
    @Override
    public void setAutoHit(boolean autoHit) {
        this.autoHit = autoHit;
    }
}
