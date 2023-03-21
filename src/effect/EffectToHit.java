package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.enums.Stat;

public class EffectToHit extends EffectDecorator{
    private final float accuracy;

    protected EffectToHit(Source source, float accuracy) {
        super(source);
        this.accuracy = accuracy;
    }

    @Override
    protected boolean doEffect(Field field, Combatant target) {
        if (field.isAllowed(this))
        {
            Combatant user = field.getCurrentAction().getUser();
            return Rng.chance(accuracy * Stat.getMod(user.getStage(Stat.ACC), target.getStage(Stat.EVA)));
        }
        else return false;
    }
}
