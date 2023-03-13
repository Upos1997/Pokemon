package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Bug extends Type {
    public Bug() {
        super("Bug", new Color(163, 182, 25),
                List.of(Fighting.getInstance(), Grass.getInstance(), Ground.getInstance()),
                List.of(Fire.getInstance(), Flying.getInstance(), Rock.getInstance()),
                Collections.emptyList());
    }

    private static final Bug instance = new Bug();
    public static Bug getInstance(){
        return instance;
    }
}
