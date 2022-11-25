package Status;

public class Poisoned extends BadlyPoisoned {
    @Override
    protected void updatePoison() {
        return;
    }

    protected double poisonDamage = 1 / 8;
}
