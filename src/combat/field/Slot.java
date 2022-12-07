package src.combat.field;

import src.pokemon.Pokemon;

public class Slot {
    private Pokemon pokemon;

    public void switchOut(Pokemon newPokemon) {
        this.pokemon = newPokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
