package src.types;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Fighting extends Type{
    private Fighting()
    {
        super("Fighting", new Color(127, 51, 27),
                new Type[]{Types.BUG.getInstance(), Types.DARK.getInstance(), Types.ROCK.getInstance()},
                new Type[]{Types.FAIRY.getInstance(), Types.FLYING.getInstance(), Types.PSYCHIC.getInstance()},
                new Type[0]);
    }

    private static final Fighting instance = new Fighting();
    public static Fighting getInstance()
    {
        return instance;
    }
}
