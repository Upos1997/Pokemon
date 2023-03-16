package src.pokemon.enums;

import java.util.List;

public enum EggGroup {
    AMORPHOUS,
    BUG,
    DRAGON,
    FAIRY,
    FIELD,
    FLYING,
    GRASS,
    HUMAN_LIKE,
    MINERAL,
    MONSTER,
    WATER1,
    WATER2,
    WATER3,
    DITTO,
    UNDISCOVERED;

    public boolean canBreed(EggGroup eggGroup){
        if (this == UNDISCOVERED || eggGroup == UNDISCOVERED){
            return false;
        } else if (this == DITTO ^ eggGroup == DITTO){
            return true;
        } else return this == eggGroup;
    }

    public boolean canBreed(List<EggGroup> eggGroupList){
        return eggGroupList.stream().anyMatch(this::canBreed);
    }
}
