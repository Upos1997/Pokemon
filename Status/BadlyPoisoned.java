package Status;

import java.util.List;

import action.Reaction;

public class BadlyPoisoned extends Status {
    protected void updatePoison() {
        poisonDamage += 1 / 16;
    }

    protected double poisonDamage = 1 / 16;
    private Reaction eotDamage = new Reaction(pokemon, Reaction.noCheck, (field) -> {
        pokemon.changeHp((int) (pokemon.getHpMax() * -poisonDamage));
        updatePoison();
        return null;
    });

    protected List<Reaction> reactions = List.of(eotDamage);
}
