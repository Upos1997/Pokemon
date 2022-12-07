package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class Action {
    protected Action(Pokemon user, Object parent){
        this.user = user;
        this.parent = parent;
    }

    protected Pokemon user;
    protected Object parent;

    public Pokemon getUser(){
        return user;
    }
    public Object getParent(){
        return parent;
    }
    protected boolean isChild() {
        return parent instanceof Action;
    }
    public Object getSource(){
        if (isChild()){
            return ((Action) parent).getSource();
        } else {
            return parent;
        }
    }

    protected void handleReactions(Field field){
        user.handleReactions(field, this);
        field.handleReactions(this);
    }

    public Object action(Field field){
        field.setCurrentAction(this);
        Object answer;
        if (field.isAllowed(this)){
            answer = takeAction(field);
            handleReactions(field);
        }else {
            answer = null;
        }
        if (isChild()){
            field.setCurrentAction((Action) parent);
        }
        return answer;
    }
    abstract public Object takeAction(Field field);
}
