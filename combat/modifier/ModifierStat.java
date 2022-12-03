package combat.modifier;

import java.util.function.Predicate;

import combat.field.Field;
import pokemon.Stat;

public class ModifierStat extends Modifier {

    public ModifierStat(MessageModifier message, Stat stat, float modifier, Predicate<Field> check) {
        super(message, modifier, check);
        this.stat = stat;
    }

    Stat stat;

    public Stat getStat() {
        return stat;
    }
}
