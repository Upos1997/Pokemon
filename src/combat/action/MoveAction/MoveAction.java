package src.combat.action.MoveAction;

import src.pokemon.Type;

import java.util.List;

public interface MoveAction{
    Object getSource();
    default List<Type> getTypes(){
        return ((MoveAction) getSource()).getTypes();
    }
    default void setTypes(List<Type> types){
        ((MoveAction) getSource()).setTypes(types);
    }
    default int getPriority(){
        return ((MoveAction) getSource()).getPriority();
    }
    default void setPriority(int priority){
        ((MoveAction) getSource()).setPriority(priority);
    }
    default float getAccuracy(){
        return ((MoveAction) getSource()).getAccuracy();
    }
    default void setAccuracy(float accuracy){
        ((MoveAction) getSource()).setAccuracy(accuracy);
    }
    default boolean isAutoHit(){
        return ((MoveAction) getSource()).isAutoHit();
    }
    default void setAutoHit(boolean autoHit){
        ((MoveAction) getSource()).setAutoHit(autoHit);
    }
}
