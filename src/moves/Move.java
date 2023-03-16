package src.moves;

import java.util.List;

import src.types.Type;

public abstract class Move {

    protected List<Type> types;
    protected float accuracy = 1;
    protected int ppMax;
    protected int priority = 0;

    public List<Type> getTypes() {
        return types;
    }
    public float getAccuracy() {
        return accuracy;
    }
    public int getPriority() {
        return priority;
    }
}
