package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class TypeGround extends Type{
    private TypeGround()
    {
        super("Ground", new Color(203, 172, 82),
                new Type[]{Types.POISON.getInstance(), Types.ROCK.getInstance()},
                new Type[]{Types.GRASS.getInstance(), Types.ICE.getInstance(), Types.WATER.getInstance()},
                new Type[]{Types.ELECTRIC.getInstance()});
    }

    private static final TypeGround instance = new TypeGround();
    public static TypeGround getInstance()
    {
            return instance;
    }

    @Override
    public void setupPrevents(Pokemon pokemon, Field field)
    {
        super.setupPrevents(pokemon, field);
        //immunity thunder wave//
    }
}
