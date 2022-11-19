package modifier;

import action.Action;
import field.Field;

public abstract class Modifier {
    protected MessageModifier message;
    protected Float modifier;
    protected Field field;
    private Boolean singleUse = false;

    public Boolean check(Action action){
        return true;
    }

    public float getmodifier(){
        if (singleUse){
            remove();
        }
        return modifier;
    }

    private Boolean remove(){
        this.field = null;
        return field.removeModifier(message, this);
    };

    protected Boolean add(Field field){
        this.field = field;
        return field.addModifier(message, this);
    }

    public Boolean makeSingleUse(){
        return this.singleUse = true;
    }

}
