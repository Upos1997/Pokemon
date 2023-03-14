package src.types;

import java.awt.Color;
import java.util.List;

public class Fairy extends Type{
    private Fairy() {
        super("Fairy", new Color(238, 167, 239),
                List.of(Bug.getInstance(), Dark.getInstance(), Fighting.getInstance()),
                List.of(Poison.getInstance(), Steel.getInstance()),
                List.of(Dragon.getInstance()));
    }

    private static final Fairy instance =  new Fairy();
    public static Fairy getInstance(){
        return instance;
    }
}
