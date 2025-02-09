public interface IGenericSort<T extends Comparable<T>> {
    void sort(T[] array);
}

