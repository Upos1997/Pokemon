package src.pokemon.enums;

public enum Stat {
    HP,
    ATK,
    DEF,
    SP_ATK,
    SP_DEF,
    SPE,
    ACC,
    EVA;

    static public double getMod(int stage) {
        if (stage < 0) {
            return 2f / (2 - stage);
        } else
            return (2 + stage) / 2f;
    }

    static public double getMod(int acc, int eva) {
        int totalStage = acc - eva;
        if (totalStage < 0) {
            return 3f / (3 - totalStage);
        } else
            return (3 + totalStage) / 3f;
    }
}
