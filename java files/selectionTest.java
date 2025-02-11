//**
/** Emily Góngora y Ale Sierra
 * test para la clase selectionSort que prueba el algoritmo con diferentes casasos como un arreglo vacío, un arreglo con un solo elemento, un arreglo ya ordenado, un arreglo en orden inverso y un arreglo desordenado.
 */

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class selectionTest {

    @Test
    public void testSelectionSort() {
        int[] array = {64, 25, 12, 22, 11};
        int[] sortedArray = {11, 12, 22, 25, 64};
        selectionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] array = {};
        int[] sortedArray = {};
        selectionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSelectionSortSingleElement() {
        int[] array = {1};
        int[] sortedArray = {1};
        selectionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSelectionSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] sortedArray = {1, 2, 3, 4, 5};
        selectionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSelectionSortReverseOrder() {
        int[] array = {5, 4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4, 5};
        selectionSort(array);
        assertArrayEquals(sortedArray, array);
    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
