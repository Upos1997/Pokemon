package src.types;

import java.awt.Color;

public class TypeDragon extends Type{
    private TypeDragon()
    {
        super("Dragon", new Color(115, 91, 220),
                new Type[]{Types.ELECTRIC.getInstance(), Types.FIRE.getInstance(), Types.GRASS.getInstance(), Types.FIRE.getInstance()},
                new Type[]{Types.DRAGON.getInstance(), Types.FAIRY.getInstance(), Types.ICE.getInstance()},
                new Type[0]);
    }

    private static final TypeDragon instance = new TypeDragon();
    public static TypeDragon getInstance()
    {
        return instance;
    }
}
