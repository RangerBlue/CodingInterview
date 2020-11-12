import issuesandalgorithms.SortingAndSearching;
import org.junit.Test;
import util.sortingandsearching.AnagramComparator;
import util.sortingandsearching.BinarySearch;
import util.sortingandsearching.MergeSort;
import util.sortingandsearching.QuickSort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortingAndSearchingTests {
    @Test
    public void testMergeSort() {
        int[] input = {1, 4, 5, 2, 5, 9, 6};
        int[] output = {1, 2, 4, 5, 5, 6, 9};
        MergeSort.mergesort(input);
        assertArrayEquals(output, input);
    }

    @Test
    public void testQuickSort() {
        int[] input = {1, 4, 5, 2, 5, 9, 6};
        int[] output = {1, 2, 4, 5, 5, 6, 9};
        QuickSort.quickSort(input, 0, input.length - 1);
        assertArrayEquals(output, input);
    }

    @Test
    public void testBinarySearch() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(2, BinarySearch.binarySearch(input, 3));
        assertEquals(2, BinarySearch.binarySearchRecursive(input, 3, 0, input.length));
    }

    //11.1
    @Test
    public void testMergeWithSort() {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 6, 7, 7, 7};
        int[] output = {1, 2, 3, 4, 4, 5, 6, 6, 7, 7, 7, 8, 10, 100};

        SortingAndSearching.merge(a, b, 8, 6);
        assertArrayEquals(output, a);
    }

    //11.2
    @Test
    public void testAnagramComparator() {
        String[] input = {"kamil", "kon", "limak", "echo", "anagram", "gramana"};
        String[] expected = {"anagram", "gramana", "kamil", "limak", "echo", "kon"};
        Arrays.sort(input, new AnagramComparator());
        assertArrayEquals(expected, input);
    }

    //11.5
    @Test
    public void testSearch() {
        String[] input = {"kamil", " ", "limak", "echo", " ", "gramana"};
        assertEquals(2, SortingAndSearching.search(input, "limak"));
    }

}
