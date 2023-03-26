package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Flying extends Type{
    private Flying()
    {
        super("Flying", new Color(139, 160, 240),
                new Type[]{Types.BUG.getInstance(), Types.FIGHTING.getInstance(), Types.GRASS.getInstance()},
                new Type[]{Types.ELECTRIC.getInstance(), Types.ICE.getInstance(), Types.ROCK.getInstance()},
                new Type[0]);
    }

    private static final Flying instance = new Flying();
    public static Flying getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //remove grounded tag//
    }
}
