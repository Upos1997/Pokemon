package src.types;

import src.combat.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Poison extends Type{
    private Poison() {
        super("Poison", new Color(145, 68, 147),
                List.of(Fighting.getInstance(), Poison.getInstance(), Bug.getInstance(), Grass.getInstance(), Fairy.getInstance()),
                List.of(Ground.getInstance(), Psychic.getInstance()),
                Collections.emptyList());
    }

    private static final Poison instance = new Poison();
    public static Poison getInstance(){
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        super.setupPrevents(pokemon, field);
        //poison immunity//
        //if grounded, remove toxic spikes//
    }
}
