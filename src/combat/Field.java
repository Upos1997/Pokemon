package src.combat;

import src.ReactionPool.hasReactionPool;
import src.combat.action.modifier.Modifiable;
import src.combat.action.prevent.Preventable;
import src.combat.action.reaction.Reactionable;
import src.combat.field.Slot;
import src.pokemon.Pokemon;
import src.terrain.Terrain;
import src.weather.WeatherName;

import java.util.List;

public interface Field extends hasReactionPool {
    WeatherName getWeather();
    boolean setWeather(WeatherName newWeather);
    Terrain getTerrain();
    boolean setTerrain(Terrain newTerrain);
    Slot getSlot(Pokemon pokemon);
    List<Slot> getFoe(Pokemon pokemon);
    List<Slot> getAdjacent(Pokemon pokemon);
    List<Slot> getAlly(Pokemon pokemon);
    List<Slot> getSelf(Pokemon pokemon);
    List<Slot> getAll();

    default boolean isAllowed(Preventable preventable) {
        return hasReactionPool.super.isAllowed(this, preventable);
    }
    default void applyModifiers(Modifiable modifiable){
        hasReactionPool.super.applyModifiers(this, modifiable);
    }
    default void handleReactions(Reactionable reactionable) {
        hasReactionPool.super.handleReactions(this, reactionable);
    }
}
