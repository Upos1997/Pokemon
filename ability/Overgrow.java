package ability;

import ability.abilityLogic.AbilityModifier;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierMove;
import pokemon.Type;

public class Overgrow extends AbilityModifier {
    Modifier modifier = new ModifierMove(MessageModifier.POWER, 1.5f, (field) -> {
        Action currentAction = field.get
        return action.hasUser(user) && action.isType(Type.GRASS) && user.isBelow(1 / 3);
    });
}
