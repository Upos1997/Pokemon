package src.types;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Psychic extends Type {
    public Psychic() {
        super("Psychic", new Color(234, 67, 123),
                List.of(Fighting.getInstance(), Psychic.getInstance()),
                List.of(Bug.getInstance(), Dark.getInstance(), Ghost.getInstance()),
                Collections.emptyList());
    }

    private static final Psychic instance = new Psychic();
    public static Psychic getInstance(){
        return instance;
    }
}
