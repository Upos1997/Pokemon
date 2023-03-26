package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class Ice extends Type {
    private Ice()
    {
        super("Ice", new Color(160, 229, 251),
                new Type[]{Types.ICE.getInstance()},
                new Type[]{Types.FIGHTING.getInstance(), Types.FIRE.getInstance(), Types.ROCK.getInstance(), Types.STEEL.getInstance()},
                new Type[0]);
    }

    private static final Ice instance = new Ice();
    public static Ice getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //immunity freezing//
        //immunity cheer cold//
    }
}
