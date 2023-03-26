package src.types;

import java.awt.Color;

public class Water extends Type{

    private Water()
    {
        super("Water", new Color(237, 63, 15),
                new Type[]{Types.FIRE.getInstance(), Types.ICE.getInstance(), Types.STEEL.getInstance(), Types.WATER.getInstance()},
                new Type[]{Types.ELECTRIC.getInstance(), Types.GRASS.getInstance()},
                new Type[0]);
    }

    static final private Water instance = new Water();
    static public Water getInstance()
    {
        return instance;
    }
}
