package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Flying extends Type{
    public Flying()
    {
        super("Flying", new Color(139, 160, 240),
                List.of(Bug.getInstance(), Fighting.getInstance(), Grass.getInstance()),
                List.of(Electric.getInstance(), Ice.getInstance(), Rock.getInstance()),
                Collections.emptyList());
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
