//**
/** Emily Góngora y Ale Sierra
 * Clase que implementa el algoritmo de ordenación Quick Sort. 
 * @param <T> tipo de dato genérico que extiende de Comparable.
*/

public class quickSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public void sort(T[] array) {
        QuickSort(array, 0, array.length - 1);
    }

    private void QuickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            QuickSort(array, low, pivotIndex - 1);
            QuickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

