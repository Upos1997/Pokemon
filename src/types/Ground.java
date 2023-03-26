package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.List;

public class Ground extends Type{
    private Ground()
    {
        super("Ground", new Color(203, 172, 82),
                new Type[]{Types.POISON.getInstance(), Types.ROCK.getInstance()},
                new Type[]{Types.GRASS.getInstance(), Types.ICE.getInstance(), Types.WATER.getInstance()},
                new Type[]{Types.ELECTRIC.getInstance()});
    }

    private static final Ground instance = new Ground();
    public static Ground getInstance()
    {
            return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //immunity thunder wave//
    }
}
