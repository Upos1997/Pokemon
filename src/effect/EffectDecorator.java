package src.effect;

import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

public abstract class EffectDecorator {
   private final Source source;
   private EffectDecorator next;

   protected EffectDecorator(Source source)
   {
      this.source = source;
   }
   
   protected abstract boolean doEffect(Field field, Pokemon[] targets);

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

   public void execute(Field field, Pokemon[] targets){
     if (doEffect(field, targets) && hasNext())
     {
        next.execute(field, targets);
     }
   }
}
