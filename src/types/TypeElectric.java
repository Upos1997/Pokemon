package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class TypeElectric extends Type{
    private TypeElectric()
    {
        super("Electric", new Color(253, 186, 24),
                new Type[]{Types.ELECTRIC.getInstance(), Types.FLYING.getInstance(), Types.STEEL.getInstance()},
                new Type[]{Types.GROUND.getInstance()},
                new Type[0]);
    }

    private static final TypeElectric instance = new TypeElectric();
    public static TypeElectric getInstance()
    {
        return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //paralysis immunity//
    }
}
