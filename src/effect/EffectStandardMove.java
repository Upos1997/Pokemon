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

public class EffectStandardMove extends EffectDecorator{
    private Type[] types;
    private int power;
    private Stat attack;
    private Stat defense;
    private final EffectCrit crit;
    private float critMul = Constants.CRIT_DAMAGE;
    private float stabMul = Constants.STAB;

    private float damageMul = 1;

    protected EffectStandardMove(Source source, Type[] types, int power, int critStageChance, Stat attack, Stat defense)
    {
        super(source);
        this.types = types;
        this.power = power;
        this.crit = new EffectCrit(source, critStageChance);
        this.attack = attack;
        this.defense = defense;
    }

    public void addType(Type type)
    {
        Type[] temp = types;
        types = new Type[types.length + 1];
        System.arraycopy(temp, 0, types, 0, types.length - 1);
        types[types.length - 1] = type;
    }
    public void setType(Type[] newTypes)
    {
        types = newTypes;
    }
    public void modPowerAdd(int change)
    {
        power += change;
    }
    public void modPowerMul(float change){
        power *= change;
    }
    public void setAttack(Stat stat)
    {
        attack = stat;
    }
    public void setDefense(Stat stat)
    {
        defense = stat;
    }
    public void modStabAdd(float change)
    {
        stabMul += change;
    }
    public void modCritDamageMul(float change)
    {
        critMul *= change;
    }

    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        Combatant user = field.getCurrentAction().getUser();
        damageMul *= Type.calcTypeEffectiveness(types, target.getTypes());
        if (damageMul == 0)
            return false;
        if (isStab(user))
            damageMul *= stabMul;
        int attackStat = user.getStat(attack);
        int defenseStat = target.getStat(defense);
        if (isCrit(field, target))
        {
            damageMul *= critMul;
            attackStat = Math.max(attackStat, user.getBaseStat(attack));
            defenseStat = Math.min(defenseStat, target.getBaseStat(defense));
        }
        damageMul *= Rng.range(Constants.DAMAGE_RANGE_MIN, Constants.DAMAGE_RANGE_MAX);
        double levelMultiplier = (2/5f*user.getLevel())+2;
        double statMultiplier = attackStat / (float) defenseStat;
        double baseDamage = (levelMultiplier * statMultiplier * power / 50f) + 2;
        int damage = (int) (baseDamage * damageMul);
        return new EffectDealDamage(getSource(), damage).execute(field, target) ;
    }

    private boolean isStab(Combatant user)
    {
        Type[] userTypes = user.getTypes();
        long distinctTypes = Stream.concat(Arrays.stream(types),Arrays.stream(userTypes)).distinct().count();
        return distinctTypes < types.length + userTypes.length;
    }

    private boolean isCrit(Field field, Combatant target)
    {
        return crit.execute(field, target);
    }
}
