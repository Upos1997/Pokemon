package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;

public class EffectCrit extends EffectDecorator
{
    private int critStageChange;
    private boolean autoCrit = false;


    public EffectCrit(Source source, int critStageChange)
    {
        super(source);
        this.critStageChange = critStageChange;
    }

    public void modChanceAdd(int change)
    {
        critStageChange += change;
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
            float critChance = Stat.getCritChance(critStage + critStageChange);
            return Rng.chance(critChance);
        }
    }
}
