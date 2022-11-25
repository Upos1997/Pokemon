package Status;

import pokemon.Pokemon;

public enum StatusName {
    BURN(new Burn()),
    FROSTBITE,
    paralysis,
    poisoned,
    badly_poisoned,
    fainted,
    drowsy,
    OK(new Status());

    StatusName(Status status) {
        this.status = status;
    }

    private Status status;

    public Status getInstance(Pokemon pokemon) {
        return status.getInstance(pokemon);
    }

    public Boolean isSame(Status status) {
        return status.getClass() == this.status.getClass();
    }
}
