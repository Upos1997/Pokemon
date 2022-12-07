package src.ability;

import src.ability.abilityLogic.Ability;
import src.pokemon.Pokemon;

public enum AbilityName {
    OVERGROW(new Overgrow(Pokemon.emptyPokemon));

    AbilityName(Ability ability) {
        this.ability = ability;
    }

    final Ability ability;

    public Ability getInstance(Pokemon user) {
        return ability.newInstance(user);
    }
}
