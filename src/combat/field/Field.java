package src.combat.field;

import src.combat.Combatant;
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
    boolean isAllowed(EffectDecorator effect, Combatant target);
    void modify(EffectDecorator effect);
    void modify(EffectDecorator effect, Combatant target);
    void reverseModify(EffectDecorator effect);
    void reverseModify(EffectDecorator effect, Combatant target);

}
