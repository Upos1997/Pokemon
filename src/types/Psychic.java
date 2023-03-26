package src.types;

import java.awt.Color;

public class Psychic extends Type {
    private Psychic()
    {
        super("Psychic", new Color(234, 67, 123),
                new Type[]{Types.FIGHTING.getInstance(), Types.PSYCHIC.getInstance()},
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.GHOST.getInstance()},
                new Type[0]);
    }

    private static final Psychic instance = new Psychic();
    public static Psychic getInstance()
    {
        return instance;
    }
}
