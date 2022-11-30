package Status;

import java.util.function.Predicate;

import action.ActionStaticDamage;
import action.Reaction;
import action.actionLogic.MessageAction;
import field.Field;
import pokemon.Pokemon;

public class BadlyPoisoned extends Status {
    BadlyPoisoned(Pokemon afflicted) {
        super(afflicted);
    }

    protected float poisonDamage = 1 / 16;

    protected void updatePoison() {
        poisonDamage += 1 / 16;
    }

    @Override
    protected void afflict(Field field) {
        Predicate<Field> dealDamage = _field -> {
            int damage = (int) (afflicted.getHpMax() * poisonDamage * -1);
            new ActionStaticDamage(afflicted, this, afflicted, damage).takeAction(field);
            updatePoison();
            return true;
        };
        Reaction eotDamage = new Reaction(MessageAction.ROUND_END, afflicted, this, afflicted, Reaction.noCheck,
                dealDamage);
        addReaction(field, eotDamage);

    }

    @Override
    public BadlyPoisoned getInstance(Pokemon pokemon) {
        return new BadlyPoisoned(pokemon);
    }
}
