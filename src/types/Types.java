package src.types;

import java.util.Arrays;

public enum Types {
    BUG(Bug.getInstance()),
    DARK(Dark.getInstance()),
    DRAGON(Dragon.getInstance()),
    ELECTRIC(Electric.getInstance()),
    FAIRY(Fairy.getInstance()),
    FIGHTING(Fighting.getInstance()),
    FIRE(Fire.getInstance()),
    FLYING(Flying.getInstance()),
    GHOST(Ghost.getInstance()),
    GRASS(Grass.getInstance()),
    GROUND(Ground.getInstance()),
    ICE(Ice.getInstance()),
    NORMAL(Normal.getInstance()),
    POISON(Poison.getInstance()),
    PSYCHIC(Psychic.getInstance()),
    ROCK(Rock.getInstance()),
    STEEL(Steel.getInstance()),
    WATER(Water.getInstance());

    private final Type instance;

    Types(Type instance)
    {
        this.instance = instance;
    }

    public Type getInstance()
    {
        return instance;
    }

    static public Type getInstance(String type)
    {
        return Arrays.stream(Types.values()).map(Types::getInstance).filter(types -> types.getName().equals(type)).findFirst().orElseThrow();
    }

    static public float calcTypeEffectiveness(Type[] attacking, Type[] defending)
    {
        float modifier = 1;
        for (Type type : defending)
            modifier *= type.getTypeEffectiveness(attacking);
        return modifier;
    }
}
