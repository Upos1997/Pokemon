package src.combat.field;

import java.util.*;

import src.ReactionPool.hasReactionPool;
import src.combat.action.Action;
import src.ReactionPool.ReactionPool;
import src.pokemon.Pokemon;
import src.terrain.Terrain;
import src.trainer.Trainer;
import src.weather.WeatherName;

public class SingleField implements Field {
    SingleField(Trainer ally, Trainer opponent) {
        this.ally = ally;
        this.opponent = opponent;
        allyPokemon.switchOut(ally.getFirstPokemon());
        opponentPokemon.switchOut(opponent.getFirstPokemon());
    }

    Trainer ally;
    Trainer opponent;
    Slot allyPokemon = new Slot();
    Slot opponentPokemon = new Slot();

    List<Action> actions = new ArrayList<>();

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

    public boolean setWeather(WeatherName newWeather) {
        if (!newWeather.equals(weather)) {
            weather = newWeather;
            return true;
        } else return false;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public boolean setTerrain(Terrain newTerrain) {
        if (!newTerrain.equals(terrain)) {
            terrain = newTerrain;
            return true;
        } else return false;
    }

    ReactionPool reactionPool = new ReactionPool();

    public ReactionPool getReactionPool() {
        return reactionPool;
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
