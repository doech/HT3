public class mergeSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(T[] array, int left, int mid, int right) {
        T[] temp = array.clone();
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }
}


