package src.weather;

import src.combat.field.SingleField;
import src.helper.Static;

public abstract class Weather extends Static {

    abstract protected void start(SingleField field);

    Weather instance;

    public Weather getInstance() {
        return instance;
    }
}
