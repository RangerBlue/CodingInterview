package exercises;

import util.mediumdifficult.Pair;

public class MediumDifficult {
    public static Pair swap(Pair x){
        x.a = x.a - x.b;
        x.b = x.a + x.b;
        x.a = x.b - x.a;
        return x;
    }
}
