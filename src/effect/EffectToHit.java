package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;

public class EffectToHit extends EffectDecorator{
    private final float accuracy;
    private final boolean autoHit = false;
    private final boolean autoMiss = false;

    protected EffectToHit(Source source, float accuracy)
    {
        super(source);
        this.accuracy = accuracy;
    }

    @Override
    protected boolean doEffect(Field field, Combatant target)
    {
        Combatant user = field.getCurrentAction().getUser();
        if (autoHit)
            return true;
        else if (autoMiss)
            return false;
        else
            return Rng.chance(accuracy * Stat.getMod(user.getStage(Stat.ACC), target.getStage(Stat.EVA)));
    }
}
