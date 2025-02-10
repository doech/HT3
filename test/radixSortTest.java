
package test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class radixSortTest {

    @Test
    public void testRadixSort() {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] sortedArray = {2, 24, 45, 66, 75, 90, 170, 802};
        radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    public void radixSort(int[] arr) {
        int n = arr.length;
        int max = getMax(arr, n);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    @Test
    public void testRadixSortEmptyArray() {
        int[] array = {0};
        int[] sortedArray = {0};
        radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testRadixSortSingleElement() {
        int[] array = {1};
        int[] sortedArray = {1};
        radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testRadixSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] sortedArray = {1, 2, 3, 4, 5};
        radixSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testRadixSortReverseOrder() {
        int[] array = {5, 4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4, 5};
        radixSort(array);
        assertArrayEquals(sortedArray, array);
    }


    private int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}