package weather;

import combat.field.Field;
import helper.Static;

public abstract class Weather extends Static {

    abstract protected void start(Field field);

    Weather instance;

    public Weather getInstance() {
        return instance;
    }
}
