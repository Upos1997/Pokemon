package ability;

import java.util.function.Predicate;

import ability.abilityLogic.Ability;
import action.MoveAction;
import action.actionLogic.MessageAction;
import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;
import pokemon.Type;

public class Overgrow extends Ability {
    Overgrow(Pokemon user) {
        super(user);
    }

    protected Predicate<Field> isActive = field -> user.isBelow(1 / 3);
    protected MessageAction activeMessage = MessageAction.CHANGE_HP;
    protected MessageAction dormantMessage = MessageAction.CHANGE_HP;

    @Override
    public Overgrow newInstance(Pokemon user) {
        return new Overgrow(user);
    }

    @Override
    protected void disableAbility(Field field) {
    }

    @Override
    protected void enableAbility(Field field) {
        Predicate<Field> predicate = _field -> {
            MoveAction action = (MoveAction) _field.getCurrentAction();
            return action.hasUser(user) && action.isType(Type.GRASS);
        };
        Modifier modifier = new Modifier(MessageModifier.DAMAGE, 1.5f, predicate);
        addModifier(field, modifier);
    }
}
