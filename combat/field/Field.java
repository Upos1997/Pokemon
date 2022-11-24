package field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import action.Action;
import action.ActionMove;
import action.MessageAction;
import action.Reaction;
import enums.Terrain;
import enums.Weather;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.MessagePrevent;
import prevent.Prevent;

public class Field {
    Slot allyPokemon = new Slot();
    Slot opponentPokemon = new Slot();

    List<Action> actions = null;

    Action currentAction;

    public Weather weather = Weather.CLEAR_SKIES;
    public Terrain terrain = Terrain.NONE;

    Map<MessageAction, List<Reaction>> reactions = new HashMap<>();
    Map<MessageModifier, List<Modifier>> modifiers = new HashMap<>();
    Map<MessagePrevent, List<Prevent>> prevents = new HashMap<>();

    public void addReaction(Reaction reaction) {
        MessageAction message = reaction.getMessage();
        List<Reaction> reactions = this.reactions.get(message);
        if (reactions == null) {
            this.reactions.put(message, List.of(reaction));
        } else {
            reactions.add(reaction);
        }
    }

    public void removeReaction(Reaction reaction) {
        MessageAction message = reaction.getMessage();
        List<Reaction> reactions = this.reactions.get(message);
        reactions.remove(reaction);
        if (reactions.isEmpty()) {
            this.reactions.remove(message);
        }
    }

    public void addModifier(Modifier modifier) {
        MessageModifier message = modifier.getMessage();
        List<Modifier> modifiers = this.modifiers.get(message);
        if (reactions == null) {
            this.modifiers.put(message, List.of(modifier));
        } else {
            modifiers.add(modifier);
        }
    }

    public void removeModifier(Modifier modifier) {
        MessageModifier message = modifier.getMessage();
        List<Modifier> modifiers = this.modifiers.get(message);
        modifiers.remove(modifier);
        if (modifiers.isEmpty()) {
            this.modifiers.remove(message);
        }
    }

    public void addPrevent(Prevent prevent) {
        MessagePrevent message = prevent.getMessage();
        List<Prevent> prevents = this.prevents.get(message);
        if (prevents == null) {
            this.prevents.put(message, List.of(prevent));
        } else {
            prevents.add(prevent);
        }
    }

    public void removePrevent(Prevent prevent) {
        MessagePrevent message = prevent.getMessage();
        List<Prevent> prevents = this.prevents.get(message);
        prevents.remove(prevent);
        if (prevents.isEmpty()) {
            this.prevents.remove(message);
        }
    }

    public List<Modifier> getModifiers(MessageModifier message) {
        return this.modifiers.get(message);
    }

    public List<Modifier> getMoveModifiers(MessageModifier message) {
        return getModifiers(message).stream().filter(modifier -> {
            return modifier.moveCheck(this);
        }).collect(Collectors.toList());
    }

    public List<Modifier> getStatModifiers(MessageModifier message, Pokemon pokemon) {
        return getModifiers(message).stream().filter(modifier -> {
            return modifier.statCheck(this, pokemon);
        }).collect(Collectors.toList());
    }

    public Boolean isAllowed(Action action, List<MessagePrevent> messages) {
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
