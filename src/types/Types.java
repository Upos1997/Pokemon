package src.types;

import java.util.Arrays;

public enum Types {
    BUG(TypeBug.getInstance()),
    DARK(TypeDark.getInstance()),
    DRAGON(TypeDragon.getInstance()),
    ELECTRIC(TypeElectric.getInstance()),
    FAIRY(TypeFairy.getInstance()),
    FIGHTING(TypeFighting.getInstance()),
    FIRE(TypeFire.getInstance()),
    FLYING(TypeFlying.getInstance()),
    GHOST(TypeGhost.getInstance()),
    GRASS(TypeGrass.getInstance()),
    GROUND(TypeGround.getInstance()),
    ICE(TypeIce.getInstance()),
    NORMAL(TypeNormal.getInstance()),
    POISON(TypePoison.getInstance()),
    PSYCHIC(TypePsychic.getInstance()),
    ROCK(TypeRock.getInstance()),
    STEEL(TypeSteel.getInstance()),
    WATER(TypeWater.getInstance());

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
