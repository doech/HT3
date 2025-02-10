//**
/** Emily Góngora y Ale Sierra
 * Clase que implementa el algoritmo de ordenación Selection Sort, el cual fue elegido por el grupo. 
 * @param <T> tipo de dato genérico que extiende de Comparable.
*/
public class selectionSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

