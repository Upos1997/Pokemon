package pokemon;

import helper.Rng;

public enum Nature {
    HARDY("Hardy", Stat.ATTACK, Stat.ATTACK),
    LONELY("Lonely", Stat.ATTACK, Stat.DEFENSE),
    BRAVE("Brave", Stat.ATTACK, Stat.SPEED),
    ADAMANT("Adamant", Stat.ATTACK, Stat.SPECIAL_ATTACK),
    NAUGHTY("Naughty", Stat.ATTACK, Stat.SPECIAL_DEFENSE),
    BOLD("Bold", Stat.DEFENSE, Stat.ATTACK),
    DOCILE("Docile", Stat.DEFENSE, Stat.DEFENSE),
    RELAXED("Relaxed", Stat.DEFENSE, Stat.SPEED),
    IMPISH("Impish", Stat.DEFENSE, Stat.SPECIAL_ATTACK),
    LAX("Lax", Stat.DEFENSE, Stat.SPECIAL_DEFENSE),
    TIMID("Timid", Stat.SPEED, Stat.ATTACK),
    HASTY("Hasty", Stat.SPEED, Stat.DEFENSE),
    SERIOUS("Serious", Stat.SPEED, Stat.SPEED),
    JOLLY("Jolly", Stat.SPEED, Stat.SPECIAL_ATTACK),
    NAIVE("Naive", Stat.SPEED, Stat.SPECIAL_DEFENSE),
    MODEST("Modest", Stat.SPECIAL_ATTACK, Stat.ATTACK),
    MILD("Mild", Stat.SPECIAL_ATTACK, Stat.DEFENSE),
    QUIET("Quiet", Stat.SPECIAL_ATTACK, Stat.SPEED),
    BASHFUL("Bashful", Stat.SPECIAL_ATTACK, Stat.SPECIAL_ATTACK),
    RASH("Rash", Stat.SPECIAL_ATTACK, Stat.SPECIAL_DEFENSE),
    CALM("Calm", Stat.SPECIAL_DEFENSE, Stat.ATTACK),
    GENTLE("Gentle", Stat.SPECIAL_DEFENSE, Stat.DEFENSE),
    SASSY("Sassy", Stat.SPECIAL_DEFENSE, Stat.SPEED),
    CAREFUL("Careful", Stat.SPECIAL_DEFENSE, Stat.SPECIAL_ATTACK),
    QUIRKY("Quirky", Stat.SPECIAL_DEFENSE, Stat.SPECIAL_DEFENSE);

    Nature(String name, Stat up, Stat down) {
        this.name = name;
        this.up = up;
        this.down = down;
    }

    String name;
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

    static public Nature random() {
        Nature[] natures = Nature.values();
        return natures[Rng.nextInt(natures.length)];
    }

    static float boost = 1.1f;
    static float detriment = 0.9f;
}
