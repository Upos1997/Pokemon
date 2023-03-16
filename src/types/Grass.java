package src.types;

import src.combat.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Grass extends Type{

    private Grass() {
        super("Grass", new Color(102, 187, 43),
                List.of(Electric.getInstance(), Grass.getInstance(), Ground.getInstance(), Water.getInstance()),
                List.of(Bug.getInstance(), Fire.getInstance(), Flying.getInstance(), Ice.getInstance(), Poison.getInstance()),
                Collections.emptyList());
    }

    static final private Grass instance = new Grass();
    public static Grass getInstance() {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        super.setupPrevents(pokemon, field);
        //Immunity Leech Seed//
        //Immunity powder tag//
    }
}
