package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class Grass extends Type{

    private Grass()
    {
        super("Grass", new Color(102, 187, 43),
                new Type[]{Types.ELECTRIC.getInstance(), Types.GRASS.getInstance(), Types.GROUND.getInstance(), Types.WATER.getInstance()},
                new Type[]{Types.BUG.getInstance(), Types.FIRE.getInstance(), Types.FLYING.getInstance(), Types.ICE.getInstance(), Types.POISON.getInstance()},
                new Type[0]);
    }

    static final private Grass instance = new Grass();
    public static Grass getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //Immunity Leech Seed//
        //Immunity powder tag//
    }
}
