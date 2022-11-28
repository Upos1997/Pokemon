package modifier;

import java.util.function.Function;

import field.Field;

public class Modifier {
    public Modifier(MessageModifier message, double modifier, Function<Field, Boolean> check) {
        this.message = message;
        this.modifier = modifier;
        this.check = check;
    }

    private MessageModifier message;
    private double modifier;
    protected Function<Field, Boolean> check;
    public static Function<Field, Boolean> noCheck = (field) -> {
        return false;
    };

    public double getmodifier() {
        return modifier;
    }

    public MessageModifier getMessage() {
        return message;
    }

    public boolean check(Field field) {
        return check.apply(field);
    }
}
