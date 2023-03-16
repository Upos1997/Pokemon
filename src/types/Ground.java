package src.types;

import src.combat.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.List;

public class Ground extends Type{
    private Ground() {
        super("Ground", new Color(203, 172, 82),
                List.of(Poison.getInstance(), Rock.getInstance()),
                List.of(Grass.getInstance(), Ice.getInstance(), Water.getInstance()),
                List.of(Electric.getInstance()));
    }

    private static final Ground instance = new Ground();
    public static Ground getInstance(){
            return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        super.setupPrevents(pokemon, field);
        //immunity thunder wave//
    }
}
