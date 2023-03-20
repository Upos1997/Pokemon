package src.effect;

import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

public class Effect extends EffectDecorator {

    public Effect(Source source)
    {
        super(source);
    }

    @Override
    protected boolean doEffect(Field field, Pokemon[] targets)
    {
        return true;
    }

    public static Effect effectFactory(Source source, String[] effectNames)
    {
        Effect newEffect = new Effect(source);
        EffectDecorator previousEffect = newEffect;
        int counter = 0;
        while(counter < effectNames.length)
        {
            EffectDecorator addedEffect;
            switch (effectNames[counter])
            {
                case ""
            }
            previousEffect.setNext(addedEffect);
            previousEffect = addedEffect;
            counter++;
        }
        return newEffect;
    }
}
