package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Electric extends Type{
    public Electric() {
        super("Electric", new Color(253, 186, 24),
                List.of(Electric.getInstance(), Flying.getInstance(), Steel.getInstance()),
                List.of(Ground.getInstance()),
                Collections.emptyList());
    }

    private static final Electric instance = new Electric();
    public static Electric getInstance(){
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        //paralysis immunity//
    }
}
