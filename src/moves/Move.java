package src.moves;

import src.helper.Source;
import src.helper.Tag;
import src.types.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class Move implements Source {

    protected Type[] types;
    protected float accuracy = 1;
    protected int ppMax;
    protected int priority = 0;
    protected List<Tag> tags = new ArrayList<>();

    Move(Type[] types, int ppMax)
    {
        this.types = types;
        this.ppMax = ppMax;
    }

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
    public boolean hasTag(Tag tag)
    {
        return tags.contains(tag);
    }
    public void addTag(Tag tag)
    {
        tags.add(tag);
    }

    public abstract void use();
}
