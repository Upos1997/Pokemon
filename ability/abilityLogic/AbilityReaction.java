package ability.abilityLogic;

import action.Reaction;
import field.Field;

public class AbilityReaction extends Ability{
    private Reaction reaction;

    @Override
    public void activate(Field field){
        field.addReaction(reaction);
    }
}
