package src.combat.action.base;

import src.helper.Source;

public abstract class BaseSource {
    BaseSource(Source source){
        this.source = source;
    }

    protected Source source;

    public Source getSource() {
        return source;
    }
}
