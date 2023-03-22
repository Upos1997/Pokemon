package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Constants;
import src.helper.Source;
import src.pokemon.enums.Stat;
import src.types.Type;

import java.util.Arrays;
import java.util.stream.Stream;

public class EffectMoveDamage extends EffectDecorator{
    private Type[] types;
    private int power;
    private Stat attack;
    private Stat defense;
    private float critChance;
    private float critDamage;

    protected EffectMoveDamage(Source source, Type[] types, int power, float critChance, float critDamage, Stat attack, Stat defense)
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
        Combatant user = field.getCurrentAction().getUser();
        if (field.isAllowed(this)){
            float typeEffectiviness = Type.calcTypeEffectiveness(types, target.getTypes());
            float stab = 1;
            if (isStab(user))
                stab = Constants.STAB;
            float critDamage = 1;
            if (isCrit())
        }
    }

    private boolean isStab(Combatant user)
    {
        Type[] userTypes = user.getTypes();
        long distinctTypes = Stream.concat(Arrays.stream(types),Arrays.stream(userTypes).distinct().count();
        return distinctTypes < types.length + userTypes.length;
    }

    private boolean isCrit()
    {
        EffectDecorator critEffect = new
    }
}
