package src.ability;

import java.util.function.Predicate;

import src.ability.abilityLogic.Ability;
import src.combat.action.MoveAction;
import combat.action.actionLogic.MessageAction;
import src.combat.field.SingleField;
import combat.modifier.MessageModifier;
import combat.modifier.Modifier;
import src.pokemon.Pokemon;
import src.pokemon.Type;

public class Overgrow extends Ability {
    Overgrow(Pokemon user) {
        super(user);
    }

    protected Predicate<SingleField> isActive = field -> user.isBelow(1/3f);
    protected MessageAction activeMessage = MessageAction.CHANGE_HP;
    protected MessageAction dormantMessage = MessageAction.CHANGE_HP;

    @Override
    public Overgrow newInstance(Pokemon user) {
        return new Overgrow(user);
    }

    @Override
    protected void disableAbility(SingleField field) {
    }

    @Override
    protected void enableAbility(SingleField field) {
        Predicate<SingleField> predicate = _field -> {
            MoveAction action = (MoveAction) _field.getCurrentAction();
            return action.hasUser(user) && action.isType(Type.GRASS);
        };
        Modifier modifier = new Modifier(MessageModifier.DAMAGE, 1.5f, predicate);
        addModifier(field, modifier);
    }
}
