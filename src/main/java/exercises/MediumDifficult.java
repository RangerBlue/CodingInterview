package exercises;

import util.mediumdifficult.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MediumDifficult {
    //17.1
    public static Pair swap(Pair x) {
        x.a = x.a - x.b;
        x.b = x.a + x.b;
        x.a = x.b - x.a;
        return x;
    }

    //17.3
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


    //17.5
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

    //17.8
    public static int getMaxSum(int[] a) {
        int maxSum = a[0];
        int runningSum = a[0];
        for (int i = 1; i < a.length; i++) {
            runningSum += a[i];
            if (maxSum < runningSum) {
                maxSum = runningSum;
            }
        }
        return maxSum;
    }

    //17.12
    public static ArrayList<Pair> findPairSums(int[] array, int sum) {
        ArrayList<Pair> results = new ArrayList<>();
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int s = array[first] + array[last];
            if (s == sum) {
                results.add(new Pair(array[first], array[last]));
                ++first;
                --last;
            } else {
                if (s < sum) {
                    ++first;
                } else {
                    --last;
                }
            }
        }
        return results;
    }
}
