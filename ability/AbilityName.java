package ability;

import ability.abilityLogic.Ability;
import pokemon.Pokemon;

public enum AbilityName {
    OVERGROW(new Overgrow(Pokemon.emptyPokemon)),
    CHLOROPHYLL(new Chlorophyl(Pokemon.emptyPokemon));

    AbilityName(Ability ability) {
        this.ability = ability;
    }

    Ability ability;

    public Ability getInstance(Pokemon user) {
        return ability.newInstance(user);
    }
}
