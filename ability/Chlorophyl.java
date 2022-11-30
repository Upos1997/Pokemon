package ability;

import java.util.function.Predicate;

import ability.abilityLogic.Ability;
import action.actionLogic.MessageAction;
import enums.Weather;
import field.Field;
import pokemon.Pokemon;
import pokemon.Stat;

public class Chlorophyl extends Ability {

    protected Chlorophyl(Pokemon user) {
        super(user);
    }

    protected Predicate<Field> isActive = field -> field.getWeather().equals(Weather.SUN)
            || field.getWeather().equals(Weather.HARSH_SUN);
    protected MessageAction activeMessage = MessageAction.WEATHER_STARTED;
    protected MessageAction dormantMessage = MessageAction.WEATHER_STARTED;

    @Override
    public Chlorophyl newInstance(Pokemon user) {
        return new Chlorophyl(user);
    }

    @Override
    protected void disableAbility(Field field) {
        user.updateMod(Stat.SPEED, 0.5f);
    }

    @Override
    protected void enableAbility(Field field) {
        user.updateMod(Stat.SPEED, 2);
    }

}
