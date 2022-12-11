package src.combat.action;

import src.combat.action.base.BaseSource1Pokemon;
import src.combat.action.modifier.Modifiable;
import src.combat.action.prevent.Preventable;
import src.combat.action.reaction.Reactionable;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

public abstract class Action<T> extends BaseSource1Pokemon implements Modifiable, Reactionable, Preventable {
    protected Action(Pokemon user, Source source){
        super(user, source);
    }

    protected T baseValue;
    public T action(Field field){
        T answer;
        if (isAllowed(field)){
            getModifiers(field);
            answer = takeAction(field);
            handleReactions(field);
        }else {
            answer = baseValue;
        }
        return answer;
    }
    abstract public T takeAction(Field field);
}
