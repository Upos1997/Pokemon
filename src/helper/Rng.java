package src.helper;
import java.util.Random;

public class Rng {
    
    static private final Random rnjesus = new Random();
    static public Boolean chance(double accuracy){
        return rnjesus.nextFloat() < accuracy;
    }
    static public double range(double a, double b){
        double rangeSize = b-a;
        return rnjesus.nextFloat()*rangeSize+a;
    }
    static public int nextInt(int max){
        return rnjesus.nextInt(max);
    }
}
