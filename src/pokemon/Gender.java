package src.pokemon;

import src.helper.Rng;

public enum Gender {
    MALE,
    FEMALE,
    GENDERLESS;

    static public Gender random(double ods){
        if (ods == -1){
            return Gender.GENDERLESS;
        } else if (Rng.chance(ods)){
            return Gender.MALE;
        } else return Gender.FEMALE;
    }
}
