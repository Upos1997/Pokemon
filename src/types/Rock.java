package src.types;

import java.awt.Color;

public class Rock extends Type{
    private Rock()
    {
        super("Rock", new Color(176, 160, 93),
                new Type[]{Types.FIRE.getInstance(), Types.FLYING.getInstance(), Types.NORMAL.getInstance(), Types.POISON.getInstance()},
                new Type[]{Types.FIGHTING.getInstance(), Types.GRASS.getInstance(), Types.GROUND.getInstance(), Types.STEEL.getInstance(), Types.WATER.getInstance()},
                new Type[0]);
    }

    private static final Rock instance = new Rock();
    public static Rock getInstance()
    {
        return instance;
    }
}
