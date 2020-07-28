import DataStructures.ArraysAndCharSequences;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndCharSequencesTests {

    @Test
    public void uniqueSentenceShouldReturnTrue(){
        String uniqueSequence = "ABcfegplm356";
        assertTrue(ArraysAndCharSequences.uniqueCharacters(uniqueSequence));
    }

    @Test
    public void notUniqueSentenceShouldReturnFalse(){
        String uniqueSequence = "abcfed1234fght1";
        assertFalse(ArraysAndCharSequences.uniqueCharacters(uniqueSequence));
    }

    @Test
    public void sequenceMoreThan256SignsShouldReturnFalse(){
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

    @Test
    public void reverseCharEndsWithNullAtTheEndSuccess(){
        char[] input = { 'a', 'b', 'c', 'd', '\u0000' };
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharEndsWithNullInTheMiddleSuccess(){
        char[] input = { 'a', 'b', 'c', 'd', '\u0000','a', 'b', 'c', 'd' };
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharStartsWithNullSuccess(){
        char[] input = { 'a', 'b', 'c', 'd', '\u0000','a', 'b', 'c', 'd' };
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseCharWithoutNullSuccess(){
        char[] input = { 'a', 'b', 'c', 'd'};
        assertArrayEquals("dcba".toCharArray(), ArraysAndCharSequences.reverse(input));
    }

    @Test
    public void reverseNullCharNullSuccess(){
        char[] input = { '\u0000'};
        assertArrayEquals("".toCharArray(), ArraysAndCharSequences.reverse(input));
    }
}
