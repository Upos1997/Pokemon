package field;

import pokemon.Pokemon;

public class Slot {
    private Pokemon pokemon;

    public void switch_out(Pokemon newPokemon) {
        this.pokemon = newPokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
