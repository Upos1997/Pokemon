package src.effect;

import src.combat.Combatant;
import src.combat.field.Field;
import src.helper.Source;

public class EffectDealDamage extends EffectDecorator{
    private int damage;

    protected EffectDealDamage(Source source, int damage) {
        super(source);
        this.damage = damage;
    }

    public void modDamageAdd(int change)
    {
        damage += change;
    }
    public void modDamageMul(float change)
    {
        damage *= change;
    }

    @Override
    protected boolean doEffect(Field field, Combatant target) {
        target.damage(damage);
        return true;
    }
}
