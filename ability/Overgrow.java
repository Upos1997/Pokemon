package ability;

import ability.abilityLogic.AbilityModifier;
import action.MoveAction;
import action.actionLogic.Action;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Type;

public class Overgrow extends AbilityModifier {
    Modifier modifier = new Modifier(MessageModifier.ATTACK, 1.5f, (field) -> {
        Action action = field.getCurrentAction();
        if (action instanceof MoveAction) {
            MoveAction actionMove = (MoveAction) action;
            return actionMove.hasUser(user) && actionMove.isType(Type.GRASS) && user.isBelow(1 / 3);
        } else
            return false;
    });
}
