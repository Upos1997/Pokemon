package src.helper;
import java.util.Random;

public class Rng {
    
    static private final Random rnjesus = new Random();
    static public Boolean chance(double odds)
    {
        return rnjesus.nextFloat() < odds;
    }
    static public float range(float a, float b)
    {
        float rangeSize;
        if(a < b)
            rangeSize = b-a;
        else
            rangeSize = a-b;
        return rnjesus.nextFloat()*rangeSize+a;
    }
    static public int nextInt(int min, int max)
    {
        return rnjesus.nextInt(min, max);
    }

    static public int nextInt(int max)
    {
        return rnjesus.nextInt(max);
    }
}
