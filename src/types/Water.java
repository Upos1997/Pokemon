package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Water extends Type{

    private Water() {
        super("Water", new Color(237, 63, 15),
                List.of(Fire.getInstance(), Ice.getInstance(), Steel.getInstance(), Water.getInstance()),
                List.of(Electric.getInstance(), Grass.getInstance()),
                Collections.emptyList());
    }

    static final private Water instance = new Water();
    static public Water getInstance() {
        return instance;
    }
}
