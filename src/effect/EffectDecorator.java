package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.Arrays;

public abstract class EffectDecorator {
   private final Source source;
   private EffectDecorator next;

   protected EffectDecorator(Source source)
   {
      this.source = source;
   }
   
   protected abstract boolean doEffect(Field field, Combatant target);

   private boolean hasNext()
   {
     return next != null;
   }
   public void setNext(EffectDecorator newNext)
   {
      next = newNext;
   }

   public Source getSource()
   {
      return source;
   }

   public void execute(Field field, Combatant[] targets){
      Combatant[] newTargets = Arrays.stream(targets).filter(target -> doEffect(field, target)).toArray(Combatant[]::new);
     if (hasNext())
        next.execute(field, newTargets);
   }
}
