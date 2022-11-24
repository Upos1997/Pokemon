package modifier;

import java.util.function.Function;

import action.ActionMove;

public class ModifierMove extends Modifier {

    public ModifierMove(MessageModifier message, Float modifier, Function<ActionMove, Boolean> check) {
        super(message, modifier);
        this.moveCheck = check;
    }
}
