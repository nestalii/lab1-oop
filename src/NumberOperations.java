import java.math.BigDecimal;
import java.math.RoundingMode;
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
       numbers.add(new BigDecimal("12.6666666556565666"));

       System.out.print("Всі числа: ");
       printNumbers(numbers, "%s");

       System.out.print("Всі числа у форматі цілих чисел: ");
       printNumbers(numbers, "%.0f");

       System.out.print("Всі числа у форматі дробних чисел з 2ма знаками після коми (точки): ");
       printNumbers(numbers, "%.2f");

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList<BigDecimal> bigDecimals = new ArrayList<>();

        for (Number num : numbers) {
            if (num instanceof Integer) {
                integers.add((Integer) num);
            } else if (num instanceof Double) {
                doubles.add((Double) num);
            } else if (num instanceof BigDecimal) {
                bigDecimals.add((BigDecimal) num);
            }
        }

        System.out.print("Відсортовані цілі числа: ");
        printIntegers(integers);

        System.out.print("Відсортовані дробові числа: ");
        printDoubles(doubles);

        System.out.print("Відсортовані BigDecimals числа: ");
        printBigDecimals(bigDecimals);

        System.out.print("\n1. Всі числа у форматі BigDecimals: ");
        printAllBigDecimals(numbers);

        BigDecimal sum = calculateSum(numbers);
        calculateProduct(numbers);
        calculateAverage(numbers.size(), sum);
        calculateMax(numbers);
        printSortedIntegers(integers);
        calculateSumOfSquare(numbers);
        calculateBigSum(numbers);

        System.out.print("9. Кожне число початкового списку помножене на 2: ");
        calculateMultipleOfTwo(numbers);

        System.out.print("10. Список за формулою (число + 10) / 2: ");
        calculateFormula(numbers);
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
            stringBuilder.append(String.format(Locale.US, "%s", number));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static void printBigDecimals(ArrayList<BigDecimal> bigDecimals) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < bigDecimals.size(); i++) {
            Number number = bigDecimals.get(i);
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(Locale.US, "%s", number));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static BigDecimal convertToBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        } else if (number instanceof Integer) {
            return BigDecimal.valueOf((Integer) number);
        } else if (number instanceof Double) {
            return BigDecimal.valueOf((Double) number);
        }
        return null;
    }

    // Task 1
    private static void printAllBigDecimals(ArrayList<Number> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            if (i > 0) {
                stringBuilder.append(", ");
            }
            BigDecimal bigDecimal = BigDecimal.valueOf(number.doubleValue());
            stringBuilder.append(String.format(Locale.US, "%s", bigDecimal));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    // Task 2
    private static BigDecimal calculateSum(ArrayList<Number> numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (Number number : numbers) {
            sum = sum.add(convertToBigDecimal(number));
        }
        System.out.printf(Locale.US, "2. Сума всіх чисел у списку: %s\n", sum);
        return sum;
    }


    // Task 3
    private static void calculateProduct(ArrayList<Number> numbers) {
        BigDecimal product = new BigDecimal(1);
        for (int i = 0; i < 5; i++) {
            Number number = numbers.get(i);
            product = product.multiply(convertToBigDecimal(number));
        }
        System.out.printf(Locale.US, "3. Добуток перших п'яти чисел у списку: %s\n", product);
    }

    // Task 4
    private static void calculateAverage(int count, BigDecimal sum) {
        BigDecimal average = sum.divide(BigDecimal.valueOf(count), RoundingMode.HALF_UP); //BigDecimal.ROUND_HALF_UP
        System.out.printf(Locale.US, "4. Cереднє значення всіх чисел у списку: %s\n", average);
    }

    // Task 5
    private static void calculateMax(ArrayList<Number> numbers) {
        BigDecimal max = convertToBigDecimal(numbers.get(0));
        for (Number number : numbers) {
            BigDecimal bigDecimalValue = convertToBigDecimal(number);
            if (bigDecimalValue.compareTo(max) > 0) {
                max = bigDecimalValue;
            }
        }
        System.out.printf("5. Найбільше число у списку: %s\n", max);
    }

    // Task 6
    private static void printSortedIntegers(ArrayList<Integer> integers) {
        System.out.print("6. Cписок, який містить тільки цілі числа з початкового списку: ");
        printIntegers(integers);
    }

    // Task 7
    private static void calculateSumOfSquare(ArrayList<Number> numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (Number number : numbers) {
            sum = sum.add(convertToBigDecimal(number).pow(2));
        }
        System.out.printf(Locale.US, "7. Сума квадратів всіх чисел: %s\n", sum);
    }

    // Task 8
    private static void calculateBigSum(ArrayList<Number> numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (Number number : numbers) {
            BigDecimal bigDecimal = convertToBigDecimal(number);
            if (bigDecimal.compareTo(BigDecimal.valueOf(50)) > 0) {
                sum = sum.add(bigDecimal);
            }
        }
        System.out.printf(Locale.US, "8. Сума всіх чисел, які більші за 50: %s\n", sum);
    }

    // Task 9
    private static void calculateMultipleOfTwo(ArrayList<Number> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            BigDecimal bigDecimal = convertToBigDecimal(number).multiply(BigDecimal.valueOf(2));
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(Locale.US, "%s", bigDecimal));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    // Task 10
    private static void calculateFormula(ArrayList<Number> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            BigDecimal bigDecimal = convertToBigDecimal(number)
                    .add(BigDecimal.valueOf(10))
                    .divide(BigDecimal.valueOf(2));

            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(String.format(Locale.US, "%s", bigDecimal));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private static void processBigDecimals(ArrayList<BigDecimal> bigDecimals) {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal bigDecimal : bigDecimals) {
            sum = sum.add(bigDecimal);
        }
    }
}
