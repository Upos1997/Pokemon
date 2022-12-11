package src.combat.field;

import src.ReactionPool.hasReactionPool;
import src.combat.action.modifier.Modifiable;
import src.combat.action.prevent.Preventable;
import src.combat.action.Action;
import src.ReactionPool.ReactionPool;
import src.combat.action.reaction.Reactionable;
import src.pokemon.Pokemon;
import src.terrain.Terrain;
import src.weather.WeatherName;

import java.util.List;

public interface Field extends hasReactionPool {
    WeatherName getWeather();
    boolean setWeather(WeatherName newWeather);
    Terrain getTerrain();
    boolean setTerrain(Terrain newTerrain);
    ReactionPool getReactionPool();

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
        hasReactionPool.super.applyActionModifiers(this, modifiable);
    }
    default void handleReactions(Reactionable reactionable) {
        hasReactionPool.super.handleReactions(this, reactionable);
    }
}
