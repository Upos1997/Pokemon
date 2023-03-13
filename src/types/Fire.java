package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

public class Fire extends Type{
    private Fire() {
        super("Fire", new Color(237, 63, 15),
                List.of(Bug.getInstance(), Fairy.getInstance(), Fire.getInstance(), Grass.getInstance(), Ice.getInstance(), Steel.getInstance()),
                List.of(Ground.getInstance(), Rock.getInstance(), Water.getInstance()),
                Collections.emptyList());
    }

    static final private Fire instance = new Fire();
    static public Fire getInstance() {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field) {
        //immunity burned//
    }
}
