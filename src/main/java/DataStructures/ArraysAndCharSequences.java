package DataStructures;

import java.util.Arrays;

public class ArraysAndCharSequences {
    //1.1
    public static boolean uniqueCharacters(String str) {
        if (str.length() > 256) {
            return false;
        }
        boolean[] temp = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (temp[str.charAt(i)]) {
                return false;
            }
            temp[str.charAt(i)] = true;
        }
        return true;
    }

    //1.2
    public static char[] reverse(char[] str) {
        int outputArraySize = 0;
        while (outputArraySize<str.length && str[outputArraySize] != '\u0000' ) {
            outputArraySize++;
        }
        char[] outputArray = String.valueOf(str).substring(0, outputArraySize).toCharArray();
        char temp;
        for (int i = 0; i < outputArraySize - 1; i++) {
            temp = outputArray[i];
            outputArray[i] = outputArray[outputArraySize - 1];
            outputArray[outputArraySize - 1] = temp;
            outputArraySize--;
        }
        return outputArray;
    }

    //1.3
    public static boolean permutation(char[] first, char[] second) {
        if (first.length == second.length) {
            Arrays.sort(first);
            Arrays.sort(second);
            if (String.valueOf(first).equals(String.valueOf(second))) {
                return true;
            }
        }
        return false;
    }
}
