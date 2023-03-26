package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Poison extends Type{
    private Poison()
    {
        super("Poison", new Color(145, 68, 147),
                new Type[]{Types.FIGHTING.getInstance(), Types.POISON.getInstance(), Types.BUG.getInstance(), Types.GRASS.getInstance(), Types.FAIRY.getInstance()},
                new Type[]{Types.GROUND.getInstance(), Types.PSYCHIC.getInstance()},
                new Type[0]);
    }

    private static final Poison instance = new Poison();
    public static Poison getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //poison immunity//
        //if grounded, remove toxic spikes//
    }
}
