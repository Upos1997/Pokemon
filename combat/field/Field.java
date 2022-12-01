package field;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import action.Reaction;
import action.actionLogic.Action;
import action.actionLogic.MessageAction;
import modifier.MessageModifier;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.MessagePrevent;
import prevent.Prevent;
import terrain.Terrain;
import weather.WeatherName;

public class Field {
    Slot allyPokemon = new Slot();
    Slot opponentPokemon = new Slot();

    List<Action> actions = null;

    Action currentAction;

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action newAction) {
        currentAction = newAction;
    }

    WeatherName weather = WeatherName.CLEAR_SKIES;
    Terrain terrain = Terrain.NONE;

    public WeatherName getWeather() {
        return weather;
    }

    public void setWeather(WeatherName newWeather) {
        if (!newWeather.equals(weather)) {
            handleReactions(MessageAction.WEATHER_STOPPED);
            weather = newWeather;
            handleReactions(MessageAction.WEATHER_STARTED);
        }
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain newTerrain) {
        if (!newTerrain.equals(terrain)) {
            handleReactions(MessageAction.TERRAIN_STOPPED);
            terrain = newTerrain;
            handleReactions(MessageAction.TERRAIN_STARTED);
        }
    }

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

    private Stream<Modifier> filterModifiers(MessageModifier message) {
        Predicate<Modifier> filter = modifier -> modifier.check(this);
        return this.modifiers.get(message).stream().filter(filter);
    }

    public List<Modifier> getModifiers(MessageModifier message) {
        return filterModifiers(message).collect(Collectors.toList());
    }

    public boolean hasModifier(MessageModifier message) {
        return filterModifiers(message).findAny().isPresent();
    }

    public Boolean isAllowed(Action action, MessagePrevent message) {
        return !prevents.get(message).stream().filter(prevent -> {
            return prevent.check(this);
        }).filter(prevent -> {
            return isPreventAllowed(prevent);
        }).findAny().isPresent();
    }

    Boolean isPreventAllowed(Prevent prevent) {
        return !prevents.get(MessagePrevent.PREVENT).stream().filter(pprevent -> {
            return pprevent.preventCheck(this, prevent);
        }).filter(pprevent -> {
            return isPreventAllowed(pprevent);
        }).findAny().isPresent();
    }

    public Void handleReactions(MessageAction message) {
        reactions.get(message).stream().filter(reaction -> reaction.check(this))
                .forEach(reaction -> reaction.takeAction(this));
        return null;
    }

    public Slot getSlot(Pokemon pokemon) {
        if (allyPokemon.getPokemon() == pokemon) {
            return allyPokemon;
        } else if (opponentPokemon.getPokemon() == pokemon) {
            return opponentPokemon;
        } else
            return null;
    }

    public List<Slot> getFoe(Pokemon pokemon) {
        if (allyPokemon.getPokemon() == pokemon) {
            return List.of(opponentPokemon);
        } else if (opponentPokemon.getPokemon() == pokemon) {
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
