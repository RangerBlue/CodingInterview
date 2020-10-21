package issuesandalgorithms;

public class BitManipulation {
    //5.1
    public static int updateBits(int n, int m, int i, int j) {
        if (i > j && Integer.toBinaryString(m).length() > (j - i)) {
            return -1;
        }
        //sequence of 1
        int allOnes = ~0;
        //1 to position of j
        int left = allOnes << (j + 1);
        //1 after position of i
        int right = ((1 << i) - 1);
        //only 0 from i to j
        int mask = left | right;
        //set 0 from i to j in input
        int n_cleared = n & mask;
        //move bits to insert to correct position
        int m_shifted = m << i;
        //add them
        return n_cleared | m_shifted;
    }

    //5.2
    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR1";
        }

        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            if (binary.length() >= 32) {
                return "ERROR2";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    //5.3
    private static int countOnes(String n) {
        int ones = 0;
        for (int i = 0; i < n.length(); i++) {
            if ((int) n.charAt(i) == '1') {
                ones++;
            }
        }
        return ones;
    }

    public static int getNextBinary(int n) {
        String inputBinaryForm = Integer.toBinaryString(n);
        int value = n + 1;
        int ones = countOnes(inputBinaryForm);
        int zeros = inputBinaryForm.length() - ones;
        int onesCount = 0;
        String bitValue = "";
        while (Integer.toBinaryString(value).length() <= inputBinaryForm.length()) {
            bitValue = Integer.toBinaryString(value);
            onesCount = countOnes(bitValue);
            if (onesCount == ones) {
                if ((bitValue.length() - onesCount) == zeros) {
                    return value;
                }
            }
            value++;
        }
        return n;
    }

    public static int getPrevBinary(int n) {
        String inputBinaryForm = Integer.toBinaryString(n);
        int value = n - 1;
        int ones = countOnes(inputBinaryForm);
        int zeros = inputBinaryForm.length() - ones;
        int onesCount = 0;
        String bitValue = "";
        while (Integer.toBinaryString(value).length() <= inputBinaryForm.length() && value > 0) {
            bitValue = Integer.toBinaryString(value);
            onesCount = countOnes(bitValue);
            if (onesCount == ones) {
                if ((bitValue.length() - onesCount) == zeros) {
                    return value;
                }
            }
            value--;
        }
        return n;
    }

    //5.5
    public static int bitSwapAmount(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }

    //5.6
    public static int swapOddEvenBits(int x) {
        int odd = x & 0b10101010101010101010101010101010;
        int even = x & 0b01010101010101010101010101010101;
        return (odd >> 1) | (even << 1);
    }

    //5.7
    public static int findMissingValue(int[] input, int length) {
        int sum = length * (length + 1) / 2;
        int inputSum = 0;
        for (int x : input) {
            inputSum += x;
        }
        return sum - inputSum;
    }

}
