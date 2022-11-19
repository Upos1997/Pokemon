package field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import action.Action;
import action.Reaction;
import enums.MessageReaction;
import enums.Targetting;
import enums.Terrain;
import enums.Weather;
import modifier.MessageModifier;
import modifier.Modifier;
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

    Map<Message, List<Reaction>> reactions = new HashMap<>();
    Map<MessageModifier, List<Modifier>> modifiers = new HashMap<>();
    List<Prevent> prevents = new ArrayList<>();

    public Boolean addReaction(MessageReaction message, Reaction reaction) {
        return reactions.get(message).add(reaction);
    }

    public Boolean removeReaction(MessageReaction message, Reaction reaction) {
        return reactions.get(message).remove(reaction);
    }

    public Boolean addModifier(MessageModifier message, Modifier modifier) {
        return modifiers.get(message).add(modifier);
    }

    public Boolean removeModifier(MessageModifier message, Modifier modifier) {
        return modifiers.get(message).remove(modifier);
    }

    public Boolean addPrevent(Prevent prevent){
        return prevents.add(prevent);
    }

    public Boolean removePrevent(Prevent prevent){
        return prevents.remove(prevent);
    }

    public float getModifier(MessageModifier message, Action action) {
        float modifier = 1;
        for (Modifier valid_modifier : modifiers.get(message).stream().filter(aModifier -> {
            return aModifier.check(action);
        }).collect(Collectors.toList())) {
            modifier *= valid_modifier.getmodifier();
        }
        return modifier;
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

    Slot getOpposing(Pokemon pokemon) {
        if (allyPokemon.pokemon == pokemon) {
            return opponentPokemon;
        } else if (opponentPokemon.pokemon == pokemon) {
            return allyPokemon;
        } else
            return null;
    }

    public List<Slot> getTargets(Targetting targetting, Pokemon user) {
        if (List.of(Targetting.ADJACENT, Targetting.ADJACENT_FOE, Targetting.FOE, Targetting.TARGET_ADJACENT,
                Targetting.TARGET_ADJACENT_FOE, Targetting.TARGET_ANY).contains(targetting)) {
            return List.of(getOpposing(user));
        } else if (List.of(Targetting.ALLY_AND_SELF, Targetting.SELF, Targetting.TARGET_ADJACENT_ALLY_OR_SELF)
                .contains(targetting)) {
            return List.of(getSlot(user));
        } else if (Targetting.ALL == targetting) {
            return List.of(getOpposing(user), getSlot(user));
        } else
            return null;
    }
}
