package ability;

import ability.abilityLogic.AbilityModifier;
import action.Action;
import action.ActionMove;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierMove;
import pokemon.Type;

public class Overgrow extends AbilityModifier {
    Modifier modifier = new ModifierMove(MessageModifier.POWER, 1.5f, (field) -> {
        Action action = field.getCurrentAction();
        if (action.getClass() == ActionMove.class) {
            ActionMove actionMove = (ActionMove) action;
            return actionMove.hasUser(user) && actionMove.isType(Type.GRASS) && user.isBelow(1 / 3);
        } else
            return false;
    });
}
