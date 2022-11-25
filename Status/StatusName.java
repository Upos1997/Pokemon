package Status;

import pokemon.Pokemon;

public enum StatusName {
    BURN(new Burn()),
    FROSTBITE(new Frostbite()),
    PARALYSIS(new Paralysis()),
    POISONED(new Poisoned()),
    BADLY_POISONED(new BadlyPoisoned()),
    FAINTED(new Status()),
    DROWSY(new Drowsy()),
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
