package src.types;

import src.combat.field.Field;
import src.helper.Constants;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.Arrays;

public abstract class Type {

    final private String name;
    final private Color color;
    final private Type[] resistances;
    final private Type[] weaknesses;
    private final Type[] immunities;

    public Type(String name, Color color, Type[] resistances, Type[] weaknesses, Type[] immunities)
    {
        this.name = name;
        this.color = color;
        this.resistances = resistances;
        this.weaknesses = weaknesses;
        this.immunities = immunities;
    }

    public String getName()
    {
        return this.name;
    }
    public Color getColor()
    {
        return this.color;
    }
    public void setupPrevents(Pokemon pokemon, Field field){}

    public float getTypeEffectiveness(Type[] types) {
        float modifier = 1;
        for (Type type : types)
            if (Arrays.stream(resistances).anyMatch(resistance -> resistance == type))
                modifier *= Constants.TYPE_RESISTANCE_MODIFIER;
            else if (Arrays.stream(weaknesses).anyMatch(weakness -> weakness == type))
                modifier *= Constants.TYPE_WEAKNESS_MODIFIER;
            else if (Arrays.stream(immunities).anyMatch(immunity -> immunity == type))
                modifier *= Constants.TYPE_IMMUNITY_MODIFIER;
        return modifier;
    }
}
