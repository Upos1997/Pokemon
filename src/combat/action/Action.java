package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class Action {
    protected Action(Pokemon user, Object source){
        this.user = user;
        this.source = source;
    }
    protected Pokemon user;
    protected Object source;

    public Pokemon getUser(){
        return user;
    }
    public Object getSource(){
        return source;
    }
    public Object getRoot(){
        if (source instanceof Action action){
            return action.getSource();
        } else {
            return source;
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
        if (source instanceof Action action){
            field.setCurrentAction(action);
        }
        return answer;
    }
    abstract public Object takeAction(Field field);
}
