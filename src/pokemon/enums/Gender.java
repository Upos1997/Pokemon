package src.pokemon.enums;

import src.helper.Rng;

public enum Gender {
    MALE,
    FEMALE,
    GENDERLESS;

    static public Gender random(double odds)
    {
        if (odds == -1)
            return Gender.GENDERLESS;
        else if (Rng.chance(odds))
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }
}
