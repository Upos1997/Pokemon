package event;

import action.Action;

public abstract class Event extends Action {
    Message message;
    
    abstract protected Boolean check();
}
