package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class Steel extends Type{
    private Steel()
    {
        super("Steel", new Color(178, 177, 193),
                new Type[]{Types.BUG.getInstance(), Types.DRAGON.getInstance(), Types.FAIRY.getInstance(), Types.GRASS.getInstance(), Types.ICE.getInstance(), Types.NORMAL.getInstance(), Types.PSYCHIC.getInstance(), Types.ROCK.getInstance(), Types.STEEL.getInstance()},
                new Type[]{Types.FIGHTING.getInstance(), Types.FIRE.getInstance(), Types.GROUND.getInstance()},
                new Type[]{Types.POISON.getInstance()});
    }

    private static final Steel instance = new Steel();
    public static Steel getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //poison immunity//
    }
}
