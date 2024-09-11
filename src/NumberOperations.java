import java.util.ArrayList;
import java.util.Locale;

public class NumberOperations {
    public static void main(String[] args) {
       ArrayList<Number> numbers = new ArrayList<>();
       numbers.add(10);
       numbers.add(20.5);
       numbers.add(30);
       numbers.add(40.7);
       numbers.add(50);
       numbers.add(60.3);
       numbers.add(70);
       numbers.add(80.1);
       numbers.add(90);
       numbers.add(100.9);

       System.out.print("Всі числа: ");
       printNumbers(numbers, "%.1f");

       System.out.print("Всі числа у форматі цілих чисел: ");
       printNumbers(numbers, "%.0f");

       System.out.print("Всі числа у форматі дробних чисел з 2ма знаками після коми (точки): ");
       printNumbers(numbers, "%.2f");

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        for (Number num : numbers) {
            if (num instanceof Integer) {
                integers.add((Integer) num);
            } else if (num instanceof Double) {
                doubles.add((Double) num);
            }
        }

        System.out.print("Відсортовані цілі числа: ");
        printIntegers(integers);

        System.out.print("Відсортовані дробові числа: ");
        printDoubles(doubles);

        calculateProduct(numbers);
    }

    private static void printNumbers(ArrayList<Number> numbers, String pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(Locale.US, pattern, number.doubleValue()));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static void printIntegers(ArrayList<Integer> integers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < integers.size(); i++) {
            Number number = integers.get(i);
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format("%d", number));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static void printDoubles(ArrayList<Double> doubles) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < doubles.size(); i++) {
            Number number = doubles.get(i);
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(Locale.US, "%.2f", number));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static void calculateProduct(ArrayList<Number> numbers) {
        double product = 1;
        for (int i = 0; i < 5; i++) {
            Number number = numbers.get(i);
            if (number instanceof Integer) {
                product *= (Integer) number;
            } else if (number instanceof Double) {
                product *= (Double) number;
            }
        }
        System.out.printf(Locale.US, "Добуток перших п'яти чисел у списку: %.2f", product);
    }
}
