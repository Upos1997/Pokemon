package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Normal extends Type{

    private Normal() {
        super("Normal", new Color(197, 192, 182),
                Collections.emptyList(),
                List.of(Fighting.getInstance()),
                List.of(Ghost.getInstance()));
    }

    static final private Normal instance = new Normal();
    static public Normal getInstance() {
        return instance;
    }
}
