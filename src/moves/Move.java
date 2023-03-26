package src.moves;

import src.types.Type;

public abstract class Move {

    protected Type[] types;
    protected float accuracy = 1;
    protected int ppMax;
    protected int priority = 0;

    public Type[] getTypes()
    {
        return types;
    }
    public float getAccuracy()
    {
        return accuracy;
    }
    public int getPpMax()
    {
        return ppMax;
    }
    public int getPriority()
    {
        return priority;
    }
}
