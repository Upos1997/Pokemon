package src.types;

import java.awt.Color;

public class TypeNormal extends Type{

    private TypeNormal()
    {
        super("Normal", new Color(197, 192, 182),
                new Type[0],
                new Type[]{Types.FIGHTING.getInstance()},
                new Type[]{Types.GHOST.getInstance()});
    }

    static final private TypeNormal instance = new TypeNormal();
    static public TypeNormal getInstance()
    {
        return instance;
    }
}
