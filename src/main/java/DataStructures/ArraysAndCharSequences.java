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
        while (outputArraySize < str.length && str[outputArraySize] != '\u0000') {
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
            return String.valueOf(first).equals(String.valueOf(second));
        }
        return false;
    }

    //1.4
    public static char[] replaceSpaces(char[] str) {
        int spaceCounter = 0;
        for (char s : str) {
            if (s == ' ') {
                spaceCounter++;
            }
        }
        int newLength = str.length + spaceCounter * 2;
        char[] output = new char[newLength];
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                output[newLength - 1] = '%';
                output[newLength - 2] = '0';
                output[newLength - 3] = '2';
                newLength -= 3;
            } else {
                output[newLength - 1] = str[i];
                newLength -= 1;
            }
        }
        return output;
    }

    //1.5
    public static String compression(String str) {
        if (compressionCount(str) >= str.length()) {
            return str;
        }
        StringBuilder output = new StringBuilder();
        char last = str.charAt(0);
        int counter = 1;
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                counter++;
            } else {
                output.append(last);
                output.append(counter);
                counter = 1;
                last = str.charAt(i);
            }
        }
        output.append(last);
        output.append(counter);
        return output.toString();
    }

    public static int compressionCount(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int size = 0;
        char last = str.charAt(0);
        int counter = 1;
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                counter++;
            } else {
                size++;
                size += String.valueOf(counter).length();
                counter = 1;
                last = str.charAt(i);
            }
        }
        size++;
        size += String.valueOf(counter).length();
        return size;
    }

    //1.6
    public static int[][] matrix90rotation(int[][] input) {
        for (int layer = 0; layer < input.length / 2; layer++) {
            int first = layer;
            int last = input.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int upper = input[first][i];
                input[first][i] = input[last - offset][first];
                input[last - offset][first] = input[last][last - offset];
                input[last][last - offset] = input[i][last];
                input[i][last] = upper;
            }
        }
        return input;
    }

    //1.7
    public static int[][] matrixSetZeroInRowsAndCols(int[][] input) {
        boolean[] rows = new boolean[input.length];
        boolean[] cols = new boolean[input[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (input[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                setZeroInRow(input, i);
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (rows[i]) {
                setZeroInColumn(input, i);
            }
        }

        return input;
    }

    public static int[][] setZeroInRow(int[][] matrix, int rowNumber) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[rowNumber][i] = 0;
        }
        return matrix;
    }

    public static int[][] setZeroInColumn(int[][] matrix, int columnNumber) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnNumber] = 0;
        }
        return matrix;
    }
}
