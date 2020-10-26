package issuesandalgorithms;

import util.mathandprobability.Line;

public class MathAndProbability {
    //7.3
    public static boolean areLinesIntersected(Line line0, Line line1) {
        return line0.isIntersected(line1);
    }

    //7.4
    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += d;
            a += d;
        }
        return neg;
    }

    public static int minus(int a, int b) {
        return a + negate(b);
    }

    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }
        int sum = 0;
        for (int i = Math.abs(b); i > 0; i--) {
            sum += a;
        }

        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dividing by zero");
        }
        int absa = Math.abs(a);
        int absb = Math.abs(b);

        int product = 0;
        int x = 0;
        while (product + absb <= absa) {
            product += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }

    }
}
