//**
/** Emily Góngora y Ale Sierra
 * Clase interface que define el método sort para el resto de algoritmos de ordenación usando generics.
 */

public interface IGenericSort<T extends Comparable<T>> {
    void sort(T[] array);
}

