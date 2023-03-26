package src.types;

import java.awt.Color;

public class TypeRock extends Type{
    private TypeRock()
    {
        super("Rock", new Color(176, 160, 93),
                new Type[]{Types.FIRE.getInstance(), Types.FLYING.getInstance(), Types.NORMAL.getInstance(), Types.POISON.getInstance()},
                new Type[]{Types.FIGHTING.getInstance(), Types.GRASS.getInstance(), Types.GROUND.getInstance(), Types.STEEL.getInstance(), Types.WATER.getInstance()},
                new Type[0]);
    }

    private static final TypeRock instance = new TypeRock();
    public static TypeRock getInstance()
    {
        return instance;
    }
}
