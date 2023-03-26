package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;
import src.moves.Move;
import src.moves.MoveDamaging;
import src.types.Type;

import java.util.Arrays;

public class Effect extends EffectDecorator {

    public Effect(Source source)
    {
        super(source);
    }

    @Override
    protected boolean doEffect(Field field, Combatant target)
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
            EffectDecorator addedEffect = new Effect(source);
            switch (effectNames[counter])
            {
                case "hit" ->
                {
                    addedEffect = new EffectToHit(source, Integer.parseInt(effectNames[counter + 1]));
                    counter++;
                }
                case "damage" ->
                {
                    addedEffect = new EffectDealDamage(source, Integer.parseInt(effectNames[counter + 1]));
                    counter++;
                }
            }
            previousEffect.setNext(addedEffect);
            previousEffect = addedEffect;
            counter++;
        }
        return newEffect;
    }
}
