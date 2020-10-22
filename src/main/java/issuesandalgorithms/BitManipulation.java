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

    //5.8
    void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 0) {
            last_full_byte--;
        }

        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        //x1 and x2 in the same byte
        if ((x1 / 8) == (x2 / 8)) {
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + last_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

}
