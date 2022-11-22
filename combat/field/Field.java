package field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import action.Action;
import action.MessageReaction;
import action.Reaction;
import enums.Terrain;
import enums.Weather;
import modifier.MessageModifier;
import modifier.Modifier;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import prevent.Prevent;

public class Field {
    Field() {
        for (MessageReaction message : MessageReaction.values()) {
            reactions.put(message, new ArrayList<>());
        }
    }

    Slot allyPokemon = new Slot();
    Slot opponentPokemon = new Slot();
    Action allyAction = null;
    Action opponentAction = null;

    public Weather weather = Weather.CLEAR_SKIES;
    public Terrain terrain = Terrain.NONE;

    Map<MessageReaction, List<Reaction>> reactions = new HashMap<>();
    List<Modifier> modifiers = new ArrayList<>();
    List<Prevent> prevents = new ArrayList<>();

    public Boolean addReaction(MessageReaction message, Reaction reaction) {
        return reactions.get(message).add(reaction);
    }

    public Boolean removeReaction(MessageReaction message, Reaction reaction) {
        return reactions.get(message).remove(reaction);
    }

    public Boolean addModifier(MessageModifier message, Modifier modifier) {
        return modifiers.add(modifier);
    }

    public Boolean removeModifier(MessageModifier message, Modifier modifier) {
        return modifiers.remove(modifier);
    }

    public Boolean addPrevent(Prevent prevent){
        return prevents.add(prevent);
    }

    public Boolean removePrevent(Prevent prevent){
        return prevents.remove(prevent);
    }

    public List<Modifier> getModifiers(Move move) {
        return modifiers.stream().filter(modifier -> {return modifier.check(move);}).collect(Collectors.toList());
    }

    public Boolean isAllowed(Action action) {
        return !prevents.stream().filter(prevent -> {
            return prevent.check(this, action);
        }).filter(prevent -> {
            return isPreventAllowed(prevent);
        }).findFirst().isPresent();
    }

    Boolean isPreventAllowed(Prevent prevent) {
        return !prevents.stream().filter(pprevent -> {
            return pprevent.preventCheck(this, prevent);
        }).filter(pprevent -> {
            return isPreventAllowed(pprevent);
        }).findFirst().isPresent();
    }

    public Void handleReactions(MessageReaction message, Action action) {
        reactions.get(message).stream().filter(reaction -> reaction.check(this, action))
                .forEach(reaction -> reaction.takeAction(this));
        return null;
    }

    public Slot getSlot(Pokemon pokemon) {
        if (allyPokemon.pokemon == pokemon) {
            return allyPokemon;
        } else if (opponentPokemon.pokemon == pokemon) {
            return opponentPokemon;
        } else
            return null;
    }

    public List<Slot> getFoe(Pokemon pokemon) {
        if (allyPokemon.pokemon == pokemon) {
            return List.of(opponentPokemon);
        } else if (opponentPokemon.pokemon == pokemon) {
            return List.of(allyPokemon);
        } else
            return null;
    }

    public List<Slot> getAdjacent(Pokemon pokemon) {
        return getFoe(pokemon);
    }

    public List<Slot> getAlly(Pokemon pokemon) {
        return Collections.emptyList();
    }

    public List<Slot> getSelf(Pokemon pokemon) {
        return List.of(getSlot(pokemon));
    }

    public List<Slot> getAll() {
        return List.of(opponentPokemon, allyPokemon);
    }
}
