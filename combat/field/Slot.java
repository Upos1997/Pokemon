package field;

import pokemon.Pokemon;

public class Slot {
    Pokemon pokemon;

    public void switch_out(Pokemon newPokemon) {
        this.pokemon = newPokemon;
    }
}
