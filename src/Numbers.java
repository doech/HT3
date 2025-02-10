//**
/** Emily Góngora y Ale Sierra
*/
import java.io.*;
import java.util.*;

/**
 * La clase Numbers es la encargada de generar números aleatorios, leer números de un archivo, ordenarlos y mostrarlos.
 * Se puede editar los intervalos de los números aleatorios y la cantidad de números a generar
 */

public class Numbers {
    private List<Integer> numbers = new ArrayList<>();
    public void generateNumbers(String filePath, int count) throws IOException {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < count; i++) {
                int num = rand.nextInt(30) + 10; 
                numbers.add(num);
                writer.write(num + "\n");
            }
        }
    }
    public Integer[] readNumbers(String filePath) throws IOException {
        numbers.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers.toArray(new Integer[0]);
    }

    public void sortNumbers(IGenericSort<Integer> sorter, Integer[] array) {
        sorter.sort(array);
    }

    public static void main(String[] args) throws IOException {
        Numbers numbers = new Numbers();
        String filePath = "numbers.txt";
        numbers.generateNumbers(filePath, 10);
        Integer[] array = numbers.readNumbers(filePath);

        IGenericSort<Integer> sorter = new quickSort<>();
        long startTime = System.nanoTime();
        numbers.sortNumbers(sorter, array);
        long endTime = System.nanoTime();

        System.out.println("Tiempo de ordenación: " + (endTime - startTime) + " nanosegundos");
        System.out.println(Arrays.toString(array));
    }
}

