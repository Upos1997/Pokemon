package modifier;

import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public class Modifier {
    public Modifier(MessageModifier message, double modifier) {
        this.message = message;
        this.modifier = modifier;
    }

    private MessageModifier message;
    private double modifier;
    protected Function<Field, Boolean> moveCheck = (field) -> {
        return false;
    };
    protected BiFunction<Field, Pokemon, Boolean> statCheck = (field, pokemon) -> {
        return false;
    };

    public double getmodifier() {
        return modifier;
    }

    public MessageModifier getMessage() {
        return message;
    }

    public Function<Field, Boolean> getMoveCheck() {
        return moveCheck;
    }

    public BiFunction<Field, Pokemon, Boolean> getStatCheck() {
        return statCheck;
    }

    public boolean moveCheck(Field field) {
        return moveCheck.apply(field);
    }

    public boolean statCheck(Field field, Pokemon pokemon) {
        return statCheck.apply(field, pokemon);
    }
}
