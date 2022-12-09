package src.combat.action.MoveAction;

import src.pokemon.Stat;

public interface MoveActionDamaging extends MoveAction {
    default int getPower(){
        return ((MoveActionDamaging) getSource()).getPower();
    }
    default void setPower(int power){
        ((MoveActionDamaging) getSource()).setPower(power);
    }
    default Stat getAttack(){
        return ((MoveActionDamaging) getSource()).getAttack();
    }
    default void setAttack(Stat attack){
        ((MoveActionDamaging) getSource()).setAttack(attack);
    }
    default Stat getDefense(){
        return ((MoveActionDamaging) getSource()).getDefense();
    }
    default void setDefense(Stat defense){
        ((MoveActionDamaging) getSource()).setDefense(defense);
    }
    default float getCritChance(){
        return ((MoveActionDamaging) getSource()).getCritChance();
    }
    default void setCritChance(float critChance){
        ((MoveActionDamaging) getSource()).setCritDamage(critChance);
    }
    default float getCritDamage(){
        return ((MoveActionDamaging) getSource()).getCritDamage();
    }
    default void setCritDamage(float critDamage){
        ((MoveActionDamaging) getSource()).setCritDamage(critDamage);
    }
    default boolean isAutoCrit(){
        return ((MoveActionDamaging) getSource()).isAutoCrit();
    }
    default void setAutoCrit(boolean autoCrit){
        ((MoveActionDamaging) getSource()).setAutoCrit(autoCrit);
    }
    default float getStab(){
        return ((MoveActionDamaging) getSource()).getStab();
    }
    default void setStab(float stab){
        ((MoveActionDamaging) getSource()).setStab(stab);
    }
    default float getDamageMod(){
        return ((MoveActionDamaging) getSource()).getDamageMod();
    }
    default void setDamageMod(float damageMod){
        ((MoveActionDamaging) getSource()).setDamageMod(damageMod);
    }
}
