package src.types;

import java.awt.Color;

public class Normal extends Type{

    private Normal()
    {
        super("Normal", new Color(197, 192, 182),
                new Type[0],
                new Type[]{Types.FIGHTING.getInstance()},
                new Type[]{Types.GHOST.getInstance()});
    }

    static final private Normal instance = new Normal();
    static public Normal getInstance()
    {
        return instance;
    }
}
