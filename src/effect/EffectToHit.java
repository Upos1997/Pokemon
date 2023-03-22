package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;

public class EffectToHit extends EffectDecorator{
    private float accuracy;
    private boolean autoHit = false;

    protected EffectToHit(Source source, float accuracy)
    {
        super(source);
        this.accuracy = accuracy;
    }

    public void modAccuracyAdd(float change)
    {
        accuracy += change;
    }

    public void modAccuracyMul(float multiplier)
    {
        accuracy *= multiplier;
    }

    public void setAutoHit()
    {
        autoHit = true;
    }



    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        Combatant user = field.getCurrentAction().getUser();
        if (autoHit)
            return true;
        else
            return Rng.chance(accuracy * Stat.getMod(user.getStage(Stat.ACC), target.getStage(Stat.EVA)));
    }
}
