package src.weather;

import src.combat.field.SingleField;
import src.helper.Source;
import src.helper.Static;

public abstract class Weather extends Static implements Source {

    abstract protected void start(SingleField field);

    Weather instance;

    public Weather getInstance() {
        return instance;
    }
}
