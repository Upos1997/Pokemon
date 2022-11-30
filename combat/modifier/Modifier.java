package modifier;

import java.util.function.Predicate;

import field.Field;

public class Modifier {
    public Modifier(MessageModifier message, double modifier, Predicate<Field> check) {
        this.message = message;
        this.modifier = modifier;
        this.check = check;
    }

    private MessageModifier message;
    private double modifier;
    protected Predicate<Field> check;
    public static Predicate<Field> noCheck = (field) -> true;

    public double getmodifier() {
        return modifier;
    }

    public MessageModifier getMessage() {
        return message;
    }

    public boolean check(Field field) {
        return check.test(field);
    }
}
