package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.List;

public class Ghost extends Type{
    private Ghost() {
        super("Ghost", new Color(91, 91, 162),
                List.of(Bug.getInstance(), Poison.getInstance()),
                List.of(Ghost.getInstance(), Dark.getInstance()),
                List.of(Normal.getInstance(), Fighting.getInstance()));
    }

    private static final Ghost instance = new Ghost();
    public static Ghost getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //immunity run prevention//
    }
}
