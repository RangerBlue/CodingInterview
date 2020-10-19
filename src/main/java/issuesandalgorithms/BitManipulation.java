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
}
