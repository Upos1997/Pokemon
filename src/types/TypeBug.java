package src.types;

import java.awt.Color;

public class TypeBug extends Type {
    private TypeBug()
    {
        super("Bug", new Color(163, 182, 25),
                new Type[]{Types.FIGHTING.getInstance(), Types.GRASS.getInstance(), Types.GROUND.getInstance()},
                new Type[]{Types.FIRE.getInstance(), Types.FLYING.getInstance(), Types.ROCK.getInstance()},
                new Type[0]);
    }

    private static final TypeBug instance = new TypeBug();
    public static TypeBug getInstance()
    {
        return instance;
    }
}
