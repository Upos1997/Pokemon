package src.combat.action.reaction;

import src.pokemon.Pokemon;

public class ReactionPokemon extends Reaction {

    public ReactionPokemon(Pokemon user, Object source) {
        super(user, source, Reaction.noCheck, Reaction.noAction);
    }
}
