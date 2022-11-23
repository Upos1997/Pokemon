package ability.abilityLogic;

import field.Field;
import prevent.Prevent;

public class AbilityPrevent extends Ability{
    Prevent prevent;
    
    @Override
    public void activate(Field field){
        field.addPrevent(prevent);
    }
}
