package src.combat.action;

import src.combat.Combatant;

public class Action {
    protected Combatant user;
    protected Combatant[] targets;

    Action(Combatant user, Combatant[] targets)
    {
        this.user = user;
        this.targets = targets;
    }

    public Combatant getUser()
    {
        return user;
    }

    public Combatant[] getTargets()
    {
        return targets;
    }


}
