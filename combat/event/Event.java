package event;

import java.util.function.Function;

import action.Action;

public abstract class Event<T> extends Action {
    Message message;
    private Function<T, Boolean> check;
    
    public Boolean check(T action) {
        return check.apply(action);
    }
}
