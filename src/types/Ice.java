package src.types;

import src.combat.Field;
import src.pokemon.Pokemon;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Ice extends Type {
    private Ice() {
        super("Ice", new Color(160, 229, 251),
                List.of(Ice.getInstance()),
                List.of(Fighting.getInstance(), Fire.getInstance(), Rock.getInstance(), Steel.getInstance()),
                Collections.emptyList());
    }

    private static final Ice instance = new Ice();
    public static Ice getInstance(){
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        super.setupPrevents(pokemon, field);
        //immunity freezing//
        //immunity cheer cold//
    }
}
