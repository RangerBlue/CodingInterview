package exercises;

import util.mediumdifficult.Pair;

import java.util.Objects;

public class MediumDifficult {
    public static Pair swap(Pair x) {
        x.a = x.a - x.b;
        x.b = x.a + x.b;
        x.a = x.b - x.a;
        return x;
    }

    public static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }

    public static int countFactZeros(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1;
        }
    }

    public static class Result {
        public int hits;
        public int pseudoHits;

        public Result(int h, int p) {
            hits = h;
            pseudoHits = p;
        }

        public Result() {
        }

        public String toString() {
            return "(" + hits + ", " + pseudoHits + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return hits == result.hits &&
                    pseudoHits == result.pseudoHits;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hits, pseudoHits);
        }
    }

    ;

    public static int code(char c) {
        switch (c) {
            case 'C':
                return 0;
            case 'P':
                return 1;
            case 'Z':
                return 2;
            case 'N':
                return 3;
            default:
                return -1;
        }
    }

    public static int MAX_COLORS = 4;

    public static Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;
        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                int code = code(solution.charAt(i));
                if (code >= 0) {
                    frequencies[code]++;
                }
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }
        return res;
    }
}
