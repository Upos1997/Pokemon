package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;

public class EffectCrit extends EffectDecorator
{
    private float critChance;
    private boolean autoCrit = false;


    protected EffectCrit(Source source, float critChance)
    {
        super(source);
        this.critChance = critChance;
    }

    public void modChanceAdd(float change)
    {
        critChance += change;
    }

    public void modChanceMul(float multiplier)
    {
        critChance *= multiplier;
    }

    public void setAutoCrit()
    {
        autoCrit = true;
    }




    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        if (autoCrit)
            return true;
        else
        {
            int critStage = field.getCurrentAction().getUser().getStage(Stat.CRIT);
            return Rng.chance(Stat.getCritChance(critStage));
        }
    }
}
