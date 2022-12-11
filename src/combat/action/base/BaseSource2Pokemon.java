package src.combat.action.base;

import src.helper.Source;
import src.pokemon.Pokemon;

public class BaseSource2Pokemon extends BaseSource1Pokemon{
    BaseSource2Pokemon(Pokemon self, Source source, Pokemon target) {
        super(self, source);
        this.target = target;
    }

    protected Pokemon target;
    public Pokemon getTarget() {
        return target;
    }
}
