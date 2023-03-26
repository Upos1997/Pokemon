package src.types;

import java.awt.Color;

public class TypeFighting extends Type{
    private TypeFighting()
    {
        super("Fighting", new Color(127, 51, 27),
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.ROCK.getInstance()},
                new Type[]{Types.FAIRY.getInstance(), Types.FLYING.getInstance(), Types.PSYCHIC.getInstance()},
                new Type[0]);
    }

    private static final TypeFighting instance = new TypeFighting();
    public static TypeFighting getInstance()
    {
        return instance;
    }
}
