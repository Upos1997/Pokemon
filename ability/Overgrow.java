package ability;

import ability.abilityLogic.AbilityModifier;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Type;

public class Overgrow extends AbilityModifier{
    Modifier modifier = new Modifier(MessageModifier.POWER, 1.5f, (action) -> {return action.isUser(user) && action.isType(Type.GRASS) && user.isBelow(1/3);});
}
