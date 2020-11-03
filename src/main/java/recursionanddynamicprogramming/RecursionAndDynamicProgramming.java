package recursionanddynamicprogramming;

import util.recursionanddynamicprogramic.Color;
import util.recursionanddynamicprogramic.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecursionAndDynamicProgramming {
    //9.1
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
        }
        return map[n];
    }

    public static boolean getPath(int x, int y, ArrayList<Point> path) {
        Point p = new Point(x, y);
        path.add(p);
        if (x == 0 && y == 0) {
            return true;
        }

        boolean success = false;
        if (x >= 1) {
            success = getPath(x - 1, y, path);
        }
        if (!success && y >= 1) {
            success = getPath(x, y - 1, path);
        }
        if (success) {
            path.add(p);
        }
        return success;
    }

    //9.3
    public static int findMagicIndex(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return findMagicIndex(array, start, mid - 1);
        } else {
            return findMagicIndex(array, mid + 1, end);
        }
    }

    public static int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length - 1);
    }

    //9.4
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { // Przypadek bazowy - dodawanie pustego zbioru
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    //9.5
    public static ArrayList<String> getPermutations(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    //9.6
    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    public static Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<String>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    //9.7
    public static boolean paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if (x < 0 || x >= screen[0].length ||
                y < 0 || y >= screen.length) {
            return false;
        }
        if (screen[y][x] == oldColor) {
            screen[y][x] = newColor;
            paintFill(screen, x - 1, y, oldColor, newColor);//left
            paintFill(screen, x + 1, y, oldColor, newColor);//right
            paintFill(screen, x, y - 1, oldColor, newColor);//up
            paintFill(screen, x, y + 1, oldColor, newColor);//down
        }
        return true;
    }

    public static boolean paintFill(Color[][] screen, int x, int y, Color newColor) {
        if (screen[y][x] == newColor) {
            return false;
        }
        return paintFill(screen, x, y, screen[y][x], newColor);
    }
}
