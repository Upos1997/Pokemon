package moves;

import java.util.List;

import field.Field;
import pokemon.Pokemon;

public interface effect {
    Void doEffect(Field field, Pokemon user, List<Pokemon> targets);
}
