package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;

public class EffectCrit extends EffectDecorator
{
    float critChance;

    protected EffectCrit(Source source, float critChance) {
        super(source);
        this.critChance = critChance;
    }


    @Override
    protected boolean doEffect(Field field, Combatant target) {
        if (field.isAllowed(this)){
            return
        }
    }
}
