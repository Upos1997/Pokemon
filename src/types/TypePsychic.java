package src.types;

import java.awt.Color;

public class TypePsychic extends Type {
    private TypePsychic()
    {
        super("Psychic", new Color(234, 67, 123),
                new Type[]{Types.FIGHTING.getInstance(), Types.PSYCHIC.getInstance()},
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.GHOST.getInstance()},
                new Type[0]);
    }

    private static final TypePsychic instance = new TypePsychic();
    public static TypePsychic getInstance()
    {
        return instance;
    }
}
