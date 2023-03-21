package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.enums.Stat;
import src.types.Type;

public class EffectDamage extends EffectDecorator{
    private Type[] types;
    private int power;
    private Stat attack;
    private Stat defense;
    private float critChance;
    private float critDamage;

    protected EffectDamage(Source source, Type[] types, int power, float critChance, float critDamage, Stat attack, Stat defense)
    {
        super(source);
        this.types = types;
        this.power = power;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.attack = attack;
        this.defense = defense;
    }


    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        if (field.isAllowed(this)){
            target.getT
        }
    }
}
