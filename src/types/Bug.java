package src.types;

import java.awt.Color;

public class Bug extends Type {
    private Bug()
    {
        super("Bug", new Color(163, 182, 25),
                new Type[]{Types.FIGHTING.getInstance(), Types.GRASS.getInstance(), Types.GROUND.getInstance()},
                new Type[]{Types.FIRE.getInstance(), Types.FLYING.getInstance(), Types.ROCK.getInstance()},
                new Type[0]);
    }

    private static final Bug instance = new Bug();
    public static Bug getInstance()
    {
        return instance;
    }
}
