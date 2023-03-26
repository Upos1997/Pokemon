package src.types;

import java.awt.Color;

public class Dark extends Type {
    private Dark()
    {
        super("Dark", new Color(79, 58, 45),
                new Type[]{Types.DARK.getInstance(), Types.GHOST.getInstance()},
                new Type[]{Types.BUG.getInstance(), Types.FAIRY.getInstance(), Types.FIGHTING.getInstance()},
                new Type[]{Types.PSYCHIC.getInstance()});
    }

    private static final Dark instance = new Dark();
    public static Dark getInstance()
    {
        return instance;
    }
}
