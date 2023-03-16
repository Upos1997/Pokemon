package src.types;

import src.combat.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.List;

public class Steel extends Type{
    private Steel() {
        super("Steel", new Color(178, 177, 193),
                List.of(Bug.getInstance(), Dragon.getInstance(), Fairy.getInstance(), Flying.getInstance(), Grass.getInstance(), Ice.getInstance(), Normal.getInstance(), Psychic.getInstance(), Rock.getInstance(), Steel.getInstance()),
                List.of(Fighting.getInstance(), Fire.getInstance(), Ground.getInstance()),
                List.of(Poison.getInstance()));
    }

    private static final Steel instance = new Steel();
    public static Steel getInstance(){
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        super.setupPrevents(pokemon, field);
        //poison immunity//
    }
}
