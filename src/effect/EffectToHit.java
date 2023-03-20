package src.effect;

import src.combat.field.Field;
import src.helper.Rng;
import src.helper.Source;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;

public class EffectToHit extends EffectDecorator{
    private final float accuracy;

    protected EffectToHit(Source source, float accuracy) {
        super(source);
        this.accuracy = accuracy;
    }

    @Override
    protected boolean doEffect(Field field, Pokemon[] targets) {
        if (field.isAllowed(this)){
            Pokemon user = field.getCurrentAction().getUser();
            return Rng.chance(accuracy);
        }

    }
}
