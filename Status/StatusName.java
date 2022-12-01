package status;

import pokemon.Pokemon;

public enum StatusName {
    BURN(new Burn(Pokemon.emptyPokemon)),
    FROSTBITE(new Frostbite(Pokemon.emptyPokemon)),
    PARALYSIS(new Paralysis(Pokemon.emptyPokemon)),
    POISONED(new Poisoned(Pokemon.emptyPokemon)),
    BADLY_POISONED(new BadlyPoisoned(Pokemon.emptyPokemon)),
    FAINTED(new Fainted(Pokemon.emptyPokemon)),
    DROWSY(new Drowsy(Pokemon.emptyPokemon)),
    OK(new Ok(Pokemon.emptyPokemon));

    StatusName(Status status) {
        this.status = status;
    }

    private Status status;

    public Status getInstance(Pokemon pokemon) {
        return status.getInstance(pokemon);
    }

    public Boolean isSame(Status status) {
        return status.getClass() == this.status.getClass();
    }
}
