package src.combat.action.base;

import src.helper.Source;
import src.pokemon.Pokemon;

public abstract class BaseSource1Pokemon implements Source{
    protected BaseSource1Pokemon(Pokemon self, Source source) {
        this.source = source;
        this.self = self;
    }
    protected Source source;
    protected Pokemon self;

    public Pokemon getSelf() {
        return self;
    }
    public Source getSource(){
        return source;
    }
}
