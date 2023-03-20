package src.combat.action;

import src.pokemon.Pokemon;

public class Action {
    protected Pokemon user;
    protected Pokemon[] targets;

    Action(Pokemon user, Pokemon[] targets)
    {
        this.user = user;
        this.targets = targets;
    }

    public Pokemon getUser()
    {
        return user;
    }

    public Pokemon[] getTargets()
    {
        return targets;
    }


}
