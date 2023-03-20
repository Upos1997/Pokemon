package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Fighting extends Type{
    private Fighting()
    {
        super("Fighting", new Color(127, 51, 27),
                List.of(Bug.getInstance(), Dark.getInstance(), Rock.getInstance()),
                List.of(Fairy.getInstance(), Flying.getInstance(), Psychic.getInstance()),
                Collections.emptyList());
    }

    static final private Fighting instance = new Fighting();
    static public Fighting getInstance()
    {
        return instance;
    }
}
