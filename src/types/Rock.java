package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Rock extends Type{
    private Rock() {
        super("Rock", new Color(176, 160, 93),
                List.of(Fire.getInstance(), Flying.getInstance(), Normal.getInstance(), Poison.getInstance()),
                List.of(Fighting.getInstance(), Grass.getInstance(), Ground.getInstance(), Steel.getInstance(), Water.getInstance()),
                Collections.emptyList());
    }

    private static final Rock instance = new Rock();
    public static Rock getInstance(){
        return instance;
    }
}
