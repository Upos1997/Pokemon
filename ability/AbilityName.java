package ability;

import ability.abilityLogic.Ability;
import pokemon.Pokemon;

public enum AbilityName {
    OVERGROW(new Overgrow()),
    CHLOROPHYLL(new Chlorophyl());

    AbilityName(Ability ability){
        this.ability = ability;
    }
    Ability ability;

    public Ability getInstance(Pokemon user){
        return ability.newInstance(user);
    }
}
