package src.types;

import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.awt.Color;

public class TypeGhost extends Type{
    private TypeGhost()
    {
        super("Ghost", new Color(91, 91, 162),
                new Type[]{Types.BUG.getInstance(), Types.POISON.getInstance()},
                new Type[]{Types.GHOST.getInstance(), Types.DARK.getInstance()},
                new Type[]{Types.NORMAL.getInstance(), Types.FIGHTING.getInstance()});
    }

    private static final TypeGhost instance = new TypeGhost();
    public static TypeGhost getInstance()
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
