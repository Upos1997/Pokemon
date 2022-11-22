package action;

import java.util.List;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public abstract class Action {
    Action(Pokemon user, List<Pokemon> target, Function<Field, Void> action){
        this.user = user;
        this.target = target;
        this.action = action;
    }
    protected Pokemon user;
    protected Function<Field, Void> action;
    protected List<Pokemon> target;
    public final static Function<Field, Void> noAction = (field) -> {
        return null;
    };

    public Pokemon getUser() {
        return this.user;
    }

    public Pokemon getTarget() {
        return this.target.get(0);
    }

    public List<Pokemon> getTargets() {
        return this.target;
    }

    protected Void takeAction(Field field, Runnable beforeAction,
            Runnable afterAction) {
        if (field.isAllowed(this)) {
            beforeAction.run();;
            action.apply(field);
            afterAction.run();
        }
        return null;
    }
}
