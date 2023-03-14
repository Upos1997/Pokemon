package src.types;

import src.combat.action.prevent.Prevent;
import src.combat.field.Field;
import src.helper.Constants;
import src.pokemon.Pokemon;

import java.awt.Color;
import java.util.List;

public abstract class Type {

    public Type(String name, Color color, List<Type> resistances, List<Type> weaknesses, List<Type> immunities) {
        this.name = name;
        this.color = color;
        this.resistances = resistances;
        this.weaknesses = weaknesses;
        this.immunities = immunities;
    }
    final private String name;
    final private Color color;

    final private List<Type> resistances;
    final private List<Type> weaknesses;
    private final List<Type> immunities;

    public String getName(){
        return this.name;
    }
    public Color getColor(){
        return this.color;
    }
    public void setupPrevents(Pokemon pokemon, Field field){}

    private float getTypeEffectiveness(List<Type> types) {
        float modifier = 1;
        for (Type type : types) {
            if (resistances.contains(type)) {
                modifier =  modifier * Constants.TYPE_RESISTANCE_MODIFIER;
            } else if (weaknesses.contains(type)) {
                modifier = modifier * Constants.TYPE_WEAKNESS_MODIFIER;
            } else if (immunities.contains(type)) {
                return 0;
            }
        }
        return modifier;
    }

    static public float calcTypeEffectiveness(List<Type> attacking, List<Type> defending) {
        float modifier = 1;
        for (Type type : defending) {
            modifier *= type.getTypeEffectiveness(attacking);
        }
        return modifier;
    }
}
