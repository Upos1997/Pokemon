package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Dragon extends Type{
    private Dragon() {
        super("Dragon", new Color(115, 91, 220),
                List.of(Electric.getInstance(), Fire.getInstance(), Grass.getInstance(), Water.getInstance()),
                List.of(Dragon.getInstance(), Fairy.getInstance(), Ice.getInstance()),
                Collections.emptyList());
    }

    private static final Dragon instance = new Dragon();
    public static Dragon getInstance(){
        return instance;
    }
}
