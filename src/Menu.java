import java.io.*;
import java.util.*;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Numbers numbers = new Numbers();
        String filePath = "numbers.txt";

        numbers.generateNumbers(filePath, 10);

        while (true) {
            System.out.println("\nSeleccione el algoritmo de ordenación:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Selection Sort");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            int option = scanner.nextInt();

            if (option == 6) {
                System.out.println("Saliendo...");
                break;
            }

            Integer[] array = numbers.readNumbers(filePath);  
            IGenericSort<Integer> sorter = selectSorter(option);

            if (sorter != null) {
                long startTime = System.nanoTime();
                numbers.sortNumbers(sorter, array);
                long endTime = System.nanoTime();

                System.out.println("Números ordenados: " + Arrays.toString(array));
                System.out.println("Tiempo de ordenación: " + (endTime - startTime) + " nanosegundos");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static IGenericSort<Integer> selectSorter(int option) {
        switch (option) {
            case 1:
                return new insertionSort<>();
            case 2:
                return new mergeSort<>();
            case 3:
                return new quickSort<>();
            case 4:
                return new radixSort();
            case 5:
                return new selectionSort<>();
            default:
                return null;
        }
    }
}
