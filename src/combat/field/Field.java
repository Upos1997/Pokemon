package src.combat.field;

import src.ReactionPool.hasReactionPool;
import src.combat.action.Action;
import src.ReactionPool.ReactionPool;
import src.moves.moveLogic.MoveStat;
import src.pokemon.Pokemon;
import src.pokemon.Stat;
import src.terrain.Terrain;
import src.weather.WeatherName;

import java.util.List;

public interface Field extends hasReactionPool {
    Action getCurrentAction();
    void setCurrentAction(Action newAction);
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

    default boolean isAllowed(Action action) {
        return hasReactionPool.super.isAllowed(this, action);
    }
    default void applyActionModifiers(Action action){
        hasReactionPool.super.applyActionModifiers(this, action);
    }
    default void applyStatModifiers(Pokemon target){
        hasReactionPool.super.applyStatModifiers(this, target);
    }
    default void handleReactions(Action action) {
        hasReactionPool.super.handleReactions(this, action);
    }
}
