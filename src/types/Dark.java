package src.types;

import java.awt.Color;
import java.util.List;

public class Dark extends Type {
    private Dark()
    {
        super("Dark", new Color(79, 58, 45),
                List.of(Dark.getInstance(), Ghost.getInstance()),
                List.of(Bug.getInstance(), Fairy.getInstance(), Fighting.getInstance()),
                List.of(Psychic.getInstance()));
    }

    private static final Dark instance = new Dark();
    public static Dark getInstance()
    {
        return instance;
    }
}
