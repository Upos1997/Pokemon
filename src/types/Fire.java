package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Fire extends Type{
    private Fire() {
        super("Fire", new Color(237, 63, 15),
                new Type[]{Types.BUG.getInstance(), Types.FAIRY.getInstance(), Types.FIRE.getInstance(), Types.GRASS.getInstance(), Types.ICE.getInstance(), Types.STEEL.getInstance()},
                new Type[]{Types.GROUND.getInstance(), Types.ROCK.getInstance(), Types.WATER.getInstance()},
                new Type[0]);
    }

    private static final Fire instance = new Fire();
    public static Fire getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //immunity burned//
    }
}
