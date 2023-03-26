package src.types;

import java.awt.Color;

public class Fairy extends Type{
    private Fairy()
    {
        super("Fairy", new Color(238, 167, 239),
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.FIGHTING.getInstance()},
                new Type[]{Types.POISON.getInstance(), Types.STEEL.getInstance()},
                new Type[]{Types.DRAGON.getInstance()});
    }

    private static final Fairy instance = new Fairy();
    public static Fairy getInstance()
    {
        return instance;
    }
}
