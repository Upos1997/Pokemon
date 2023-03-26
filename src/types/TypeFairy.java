package src.types;

import java.awt.Color;

public class TypeFairy extends Type{
    private TypeFairy()
    {
        super("Fairy", new Color(238, 167, 239),
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.FIGHTING.getInstance()},
                new Type[]{Types.POISON.getInstance(), Types.STEEL.getInstance()},
                new Type[]{Types.DRAGON.getInstance()});
    }

    private static final TypeFairy instance = new TypeFairy();
    public static TypeFairy getInstance()
    {
        return instance;
    }
}
