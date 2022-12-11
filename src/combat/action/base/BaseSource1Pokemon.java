package src.combat.action.base;

import src.helper.Source;
import src.pokemon.Pokemon;

public class BaseSource1Pokemon extends BaseSource{
    protected BaseSource1Pokemon(Pokemon self, Source source) {
        super(source);
        this.self = self;
    }
    protected Pokemon self;

    public Pokemon getSelf() {
        return self;
    }
}
