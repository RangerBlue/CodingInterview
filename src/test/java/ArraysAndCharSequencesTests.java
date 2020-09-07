import DataStructures.ArraysAndCharSequences;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndCharSequencesTests {

    //1.1
    @Test
    public void uniqueSentenceShouldReturnTrue() {
        String uniqueSequence = "ABcfegplm356";
        assertTrue(ArraysAndCharSequences.uniqueCharacters(uniqueSequence));
    }

    @Test
    public void notUniqueSentenceShouldReturnFalse() {
        String uniqueSequence = "abcfed1234fght1";
        assertFalse(ArraysAndCharSequences.uniqueCharacters(uniqueSequence));
    }

    @Test
    public void sequenceMoreThan256SignsShouldReturnFalse() {
        String tooLongSequence = "Al contrario del pensamiento popular, el texto de Lorem Ipsum no es simplemente " +
                "texto aleatorio. Tiene sus raices en una pieza cl´sica de la literatura del Latin, que data del " +
                "año 45 antes de Cristo, haciendo que este adquiera mas de 2000 años de antiguedad. Richard " +
                "McClintock, un profesor de Latin de la Universidad de Hampden-Sydney en Virginia, encontró una" +
                " de las palabras más oscuras de la lengua del latín, \"consecteur\", en un pasaje de Lorem Ipsum," +
                " y al seguir leyendo distintos textos del latín, descubrió la fuente indudable. Lorem Ipsum viene " +
                "de las secciones 1.10.32 y 1.10.33 de \"de Finnibus Bonorum et Malorum\" (Los Extremos del Bien y El " +
                "Mal) por Cicero, escrito en el año 45 antes de Cristo. Este libro es un tratado de teoría de éticas," +
                " muy popular durante el Renacimiento. La primera linea del Lorem Ipsum, \"Lorem ipsum dolor sit amet." +
                ".\", viene de una linea en la sección 1.10.32";
        assertFalse(ArraysAndCharSequences.uniqueCharacters(tooLongSequence));
    }

    //1.2
    @Test
    public void reverseCharEndsWithNullAtTheEndSuccess() {
        char[] input = {'a', 'b', 'c', 'd', '\u0000'};
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharEndsWithNullInTheMiddleSuccess() {
        char[] input = {'a', 'b', 'c', 'd', '\u0000', 'a', 'b', 'c', 'd'};
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharStartsWithNullSuccess() {
        char[] input = {'a', 'b', 'c', 'd', '\u0000', 'a', 'b', 'c', 'd'};
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharWithoutNullSuccess() {
        char[] input = {'a', 'b', 'c', 'd'};
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseNullCharNullSuccess() {
        char[] input = {'\u0000'};
        assertArrayEquals("".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    //1.3
    @Test
    public void permutationTheSameSequenceShouldReturnTrue() {
        char[] first = {'a', 'b', 'c', 'd'};
        char[] second = {'a', 'c', 'd', 'b'};
        assertTrue(ArraysAndCharSequences.permutation(first, second));
    }

    @Test
    public void permutationUpperCaseShouldReturnFalse() {
        char[] first = {'A', 'b', 'c', 'd'};
        char[] second = {'a', 'c', 'd', 'b'};
        assertFalse(ArraysAndCharSequences.permutation(first, second));
    }

    @Test
    public void permutationDifferentSequenceShouldReturnFalse() {
        char[] first = {'a', 'b', 'c', 'd'};
        char[] second = {'a', 'c', 'd', 'a'};
        assertFalse(ArraysAndCharSequences.permutation(first, second));
    }

    @Test
    public void permutationDifferentLengthShouldReturnFalse() {
        char[] first = {'a', 'b', 'c', 'd'};
        char[] second = {'a', 'c', 'd', 'a', 'a'};
        assertFalse(ArraysAndCharSequences.permutation(first, second));
    }

    //1.4
    @Test
    public void replaceSpacesOneSpaceSuccess() {
        char[] input = {'a', ' ', 'c', 'd'};
        assertArrayEquals("a20%cd".toCharArray(), ArraysAndCharSequences.replaceSpaces(input));
    }

    @Test
    public void replaceSpacesTwoSpacesSuccess() {
        char[] input = {'a', ' ', 'c', ' ', 'd'};
        assertArrayEquals("a20%c20%d".toCharArray(), ArraysAndCharSequences.replaceSpaces(input));
    }

    @Test
    public void replaceSpacesTwoSpacesTwoOnEdgesSuccess() {
        char[] input = {' ', 'a', ' ', 'c', ' ', 'd', ' '};
        assertArrayEquals("20%a20%c20%d20%".toCharArray(), ArraysAndCharSequences.replaceSpaces(input));
    }

    //1.5
    @Test
    public void compressSequenceSuccess() {
        String input = "aaabbbccc";
        assertEquals("a3b3c3", ArraysAndCharSequences.compression(input));
    }

    @Test
    public void compressSequenceShortSuccess() {
        String input = "abc";
        assertEquals("abc", ArraysAndCharSequences.compression(input));
    }

    @Test
    public void compressSequenceEmpty() {
        String input = "";
        assertEquals("", ArraysAndCharSequences.compression(input));
    }

    @Test
    public void compressionCountLength3Expect6() {
        String input = "abc";
        assertEquals(6, ArraysAndCharSequences.compressionCount(input));
    }

    @Test
    public void compressionCountLength4Expect6() {
        String input = "abcc";
        assertEquals(6, ArraysAndCharSequences.compressionCount(input));
    }

    @Test
    public void compressionSequenceWithSpecialCharacters() {
        String input = "aaaaaa-bb 1c-ccccccccc9%^";
        assertEquals("a6-1b2 111c1-1c991%1^1", ArraysAndCharSequences.compression(input));
    }

    @Test
    public void compressionSequenceWithTwoDigitCounter() {
        String input = "aaaaaaaaaaaBcccccccccccc";
        assertEquals("a11B1c12", ArraysAndCharSequences.compression(input));
    }

    //1.6
    @Test
    public void matrix3x3rotation() {
        int[][] input = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        int[][] output = {
                {3, 2, 1},
                {3, 2, 1},
                {3, 2, 1}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrix90rotation(input));
    }

    @Test
    public void matrix4x4Rotation() {
        int[][] input = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        int[][] output = {
                {4, 3, 2, 1},
                {4, 3, 2, 1},
                {4, 3, 2, 1},
                {4, 3, 2, 1}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrix90rotation(input));
    }

    @Test
    public void matrix1x1Rotation() {
        int[][] input = {
                {1}
        };

        int[][] output = {
                {1}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrix90rotation(input));
    }

    @Test
    public void matrix0x0Rotation() {
        int[][] input = {};
        int[][] output = {};
        assertArrayEquals(output, ArraysAndCharSequences.matrix90rotation(input));
    }

    //1.7
    @Test
    public void setZeroInMatrixOneZeroSuccess() {
        int[][] input = {
                {1, 1, 1, 1},
                {2, 0, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        int[][] output = {
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {3, 0, 3, 3},
                {4, 0, 4, 4}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrixSetZeroInRowsAndCols(input));
    }

    @Test
    public void setZeroInMatrixTwoZerosSuccess() {
        int[][] input = {
                {1, 1, 1, 1},
                {2, 0, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 0}
        };

        int[][] output = {
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {3, 0, 3, 0},
                {0, 0, 0, 0}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrixSetZeroInRowsAndCols(input));
    }

    @Test
    public void setZeroIn1x1MatrixSuccess() {
        int[][] input = {
                {0}
        };

        int[][] output = {
                {0}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrixSetZeroInRowsAndCols(input));
    }

    @Test
    public void doNotSetZeroIn1x1MatrixSuccess() {
        int[][] input = {
                {1}
        };

        int[][] output = {
                {1}
        };
        assertArrayEquals(output, ArraysAndCharSequences.matrixSetZeroInRowsAndCols(input));
    }

    //1.8
    @Test
    public void isRotationAt5ElementReturnsTrue() {
        String input = "koniklaj";
        String original = "lajkonik";
        assertTrue(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationAt2ElementReturnsTrue() {
        String input = "jkonikla";
        String original = "lajkonik";
        assertTrue(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationTheSameArgumentsReturnsTrue() {
        String input = "lajkonik";
        String original = "lajkonik";
        assertTrue(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationReturnsFalse() {
        String input = "klajonik";
        String original = "lajkonik";
        assertFalse(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationEmptyFirstArgumentReturnsFalse() {
        String input = "";
        String original = "lajkonik";
        assertFalse(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationEmptySecondArgumentReturnsFalse() {
        String input = "koniklaj";
        String original = "";
        assertFalse(ArraysAndCharSequences.isRotation(input, original));
    }

    @Test
    public void isRotationEmptyArgumentsReturnsFalse() {
        String input = "";
        String original = "";
        assertFalse(ArraysAndCharSequences.isRotation(input, original));
    }
}
