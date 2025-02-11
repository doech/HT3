//**
/** Emily Góngora y Ale Sierra
 * test para la clase quickSort que prueba el algoritmo con diferentes casasos como un arreglo vacío, un arreglo con un solo elemento, un arreglo ya ordenado, un arreglo en orden inverso y un arreglo desordenado.
 */
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class quickSortTest {

    @Test
    public void testQuickSort() {
        quickSort<Integer> sorter = new quickSort<>();
        Integer[] array = {3, 6, 8, 10, 1, 2, 1};
        Integer[] expected = {1, 1, 2, 3, 6, 8, 10};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortEmptyArray() {
        quickSort<Integer> sorter = new quickSort<>();
        Integer[] array = {};
        Integer[] expected = {};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortSingleElement() {
        quickSort<Integer> sorter = new quickSort<>();
        Integer[] array = {1};
        Integer[] expected = {1};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortAlreadySorted() {
        quickSort<Integer> sorter = new quickSort<>();
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortReverseOrder() {
        quickSort<Integer> sorter = new quickSort<>();
        Integer[] array = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }
}