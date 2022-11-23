package pokemon;

import helper.Rng;

public enum Nature {
    HARDY(Stat.ATTACK, Stat.ATTACK),
    LONELY(Stat.ATTACK, Stat.DEFENSE),
    BRAVE(Stat.ATTACK, Stat.SPEED),
    ADAMANT(Stat.ATTACK, Stat.SPECIAL_ATTACK),
    NAUGHTY(Stat.ATTACK, Stat.SPECIAL_DEFENSE),
    BOLD(Stat.DEFENSE, Stat.ATTACK),
    DOCILE(Stat.DEFENSE, Stat.DEFENSE),
    RELAXED(Stat.DEFENSE, Stat.SPEED),
    IMPISH(Stat.DEFENSE, Stat.SPECIAL_ATTACK),
    LAX(Stat.DEFENSE, Stat.SPECIAL_DEFENSE),
    TIMID(Stat.SPEED, Stat.ATTACK),
    HASTY(Stat.SPEED, Stat.DEFENSE),
    SERIOUS(Stat.SPEED, Stat.SPEED),
    JOLLY(Stat.SPEED, Stat.SPECIAL_ATTACK),
    NAIVE(Stat.SPEED, Stat.SPECIAL_DEFENSE),
    MODEST(Stat.SPECIAL_ATTACK, Stat.ATTACK),
    MILD(Stat.SPECIAL_ATTACK, Stat.DEFENSE),
    QUIET(Stat.SPECIAL_ATTACK, Stat.SPEED),
    BASHFUL(Stat.SPECIAL_ATTACK, Stat.SPECIAL_ATTACK),
    RASH(Stat.SPECIAL_ATTACK, Stat.SPECIAL_DEFENSE),
    CALM(Stat.SPECIAL_DEFENSE, Stat.ATTACK),
    GENTLE(Stat.SPECIAL_DEFENSE, Stat.DEFENSE),
    SASSY(Stat.SPECIAL_DEFENSE, Stat.SPEED),
    CAREFUL(Stat.SPECIAL_DEFENSE, Stat.SPECIAL_ATTACK),
    QUIRKY(Stat.SPECIAL_DEFENSE, Stat.SPECIAL_DEFENSE);

    Nature(Stat up, Stat down) {
        this.up = up;
        this.down = down;
    }

    Stat up;
    Stat down;

    public float get_modifier(Stat stat) {
        if (up == stat && down == stat) {
            return 1;
        } else if (up == stat) {
            return boost;
        } else if (down == stat) {
            return detriment;
        } else {
            return 1;
        }
    }

    static public Nature random(){
        Nature[] natures = Nature.values();
        return natures[Rng.nextInt(natures.length)];
    }

    static float boost = 1.1f;
    static float detriment = 0.9f;
}
