package src.ability;

import java.util.function.Predicate;

import src.ability.abilityLogic.Ability;
import src.combat.field.SingleField;
import src.pokemon.Pokemon;
import src.types.Type;

public class Overgrow extends Ability {
    private Overgrow() {
        super();

    }

    protected Predicate<SingleField> isActive = field -> user.isBelow(1/3f);

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

    private final Overgrow overgrow = new Overgrow();

    public static Overgrow getInstance(){
        return overgrow;
    }
}
