package ability.abilityLogic;

import field.Field;
import modifier.Modifier;

public class AbilityModifier extends Ability{
    Modifier modifier;
    
    @Override
    public void activate(Field field){
        field.addModifier(modifier);
    }
}
