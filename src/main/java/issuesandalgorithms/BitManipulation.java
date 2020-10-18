package issuesandalgorithms;

public class BitManipulation {
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
}
