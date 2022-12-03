package ability;

import java.util.function.Predicate;

import ability.abilityLogic.Ability;
import combat.action.MoveAction;
import combat.action.actionLogic.MessageAction;
import combat.field.Field;
import combat.modifier.MessageModifier;
import combat.modifier.Modifier;
import pokemon.Pokemon;
import pokemon.Type;

public class Overgrow extends Ability {
    Overgrow(Pokemon user) {
        super(user);
    }

    protected Predicate<Field> isActive = field -> user.isBelow(1/3f);
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
