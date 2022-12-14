package src.combat.action.MoveAction;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionTargeted;
import src.combat.field.Field;
import src.helper.Rng;
import src.moves.moveLogic.MoveDamaging;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;
import src.pokemon.enums.Type;

public class MoveActionDamage extends ActionTargeted<Integer>{
    public MoveActionDamage(ActionMoveDamaging source, Pokemon target) {
        super(source.getSelf(), source, target);
        this.move =  source.getSource();
        this.attack = source.attack;
        this.defense = source.defense;
        this.power = source.power;
        this.stab = source.stab;
        this.damageMod = source.damageMod;
        this.baseValue = 0;
    }

    @Override
    public ActionMoveDamaging getSource() {
        return (ActionMoveDamaging) source;
    }

    public MoveDamaging move;
    public int power;
    public float damageMod;
    public float stab;
    public Stat attack;
    public Stat defense;
    public int attackNumber;
    public int defenseNumber;
    public float critDamage;

    private boolean isStab(){
        return self.getTypes().stream().anyMatch(type -> move.getTypes().contains(type));
    }
    private boolean isCrit(Field field) {
        return new MoveActionCrit(this).takeAction(field);
    }

    @Override
    protected Integer takeAction(Field field) {
        attackNumber = self.getAdjustedStat(attack);
        defenseNumber = target.getAdjustedStat(defense);
        if (isCrit(field)){
            damageMod *= critDamage;
            attackNumber = Math.max(attackNumber, self.getStat(attack));
            defenseNumber = Math.min(defenseNumber, target.getStat(defense));
        }
        if (isStab()){
            damageMod *= stab;
        }
        damageMod *= Type.calcTypeEffectiveness(move.getTypes(), target.getTypes());
        damageMod *= Rng.range(0.85, 1);
        return (int) (((2/5f*self.getLevel()+2)*power*attackNumber/defenseNumber/50+2)*damageMod);
    }
}
