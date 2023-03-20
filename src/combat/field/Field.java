package src.combat.field;

import src.combat.action.Action;
import src.effect.EffectDecorator;
import src.terrain.Terrain;
import src.weather.Weather;

public interface Field {
    Weather getWeather();
    boolean setWeather(Weather newWeather);
    Terrain getTerrain();
    boolean setTerrain(Terrain newTerrain);
    Action getCurrentAction();
    boolean isAllowed(EffectDecorator effect);
}
