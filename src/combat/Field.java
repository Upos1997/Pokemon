package src.combat;

import src.terrain.Terrain;
import src.weather.Weather;

public interface Field {
    Weather getWeather();
    boolean setWeather(Weather newWeather);
    Terrain getTerrain();
    boolean setTerrain(Terrain newTerrain);
}
