package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;

import java.util.Arrays;

public abstract class EffectDecorator {
   private final Source source;
   private EffectDecorator next;

   protected EffectDecorator(Source source)
   {
      this.source = source;
   }

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

   public boolean execute(Field field, Combatant[] targets){
      if (field.isAllowed(this))
      {
         field.modify(this);
         Combatant[] newTargets = Arrays.stream(targets).filter(target -> doEffect(field, target)).toArray(Combatant[]::new);
         if (newTargets.length == 0)
            return false;
         if (hasNext())
            next.execute(field, newTargets);
         field.reverseModify(this);
         return true;
      }
      else
         return false;
   }

   public boolean execute(Field field, Combatant target)
   {
      if (field.isAllowed(this, target))
      {
         field.modify(this, target);
         boolean result = doEffect(field, target);
         if (result && hasNext())
            result = next.execute(field, target);
         field.reverseModify(this, target);
         return result;
      }
      else
         return false;
   }

   protected abstract boolean doEffect(Field field, Combatant target);
}
