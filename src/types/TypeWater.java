package src.types;

import java.awt.Color;

public class TypeWater extends Type{

    private TypeWater()
    {
        super("Water", new Color(237, 63, 15),
                new Type[]{Types.FIRE.getInstance(), Types.ICE.getInstance(), Types.STEEL.getInstance(), Types.WATER.getInstance()},
                new Type[]{Types.ELECTRIC.getInstance(), Types.GRASS.getInstance()},
                new Type[0]);
    }

    static final private TypeWater instance = new TypeWater();
    static public TypeWater getInstance()
    {
        return instance;
    }
}
