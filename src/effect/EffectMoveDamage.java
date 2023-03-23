package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Constants;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;
import src.types.Type;

import java.util.Arrays;
import java.util.stream.Stream;

public class EffectMoveDamageCalc extends EffectDecorator{
    private Type[] types;
    private int power;
    private Stat attack;
    private Stat defense;
    private final EffectCrit crit;
    private float critMul = Constants.CRIT_DAMAGE;
    private float damageMul = 1;

    protected EffectMoveDamage(Source source, Type[] types, int power, int critStageChance, Stat attack, Stat defense)
    {
        super(source);
        this.types = types;
        this.power = power;
        this.crit = new EffectCrit(source, critStageChance);
        this.attack = attack;
        this.defense = defense;
    }


    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        Combatant user = field.getCurrentAction().getUser();
        if (field.isAllowed(this)){
            float typeEffectiveness = Type.calcTypeEffectiveness(types, target.getTypes());
            if (typeEffectiveness == 0)
                return false;
            float stab = 1;
            if (isStab(user))
                stab = Constants.STAB;
            float critDamage = 1;
            if (isCrit())
                critDamage = critMul;
            double random = Rng.range(0.85, 1);
            double levelMultiplier = (2/5f*user.getLevel())+2;
            double statMultiplier = user.getStat(attack) / (float) target.getStat(defense);
            double baseDamage = (levelMultiplier * statMultiplier * power / 50f) + 2;
            return ;
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
        return crit.execute();
    }
}
