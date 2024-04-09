import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Примеры вызовов функций
        int[] arr1 = {10, 1, 32, 3, 45};
        System.out.println("Минимум в массиве: " + findMinimum(arr1));

        int[] arr2 = {3, 2, 4, 1};
        System.out.println("Среднее значение массива: " + findAverage(arr2));

        int n1 = 7;
        System.out.println(n1 + (isPrime(n1) ? " Prime" : " Composite"));

        int n2 = 5;
        System.out.println("Факториал: " + factorial(n2));

        int n3 = 5;
        System.out.println("Число Фибоначчи: " + fibonacci(n3));

        int a = 2, n = 10;
        System.out.println("Возведение в степень: " + power(a, n));

        String s = "IOX";
        System.out.println("Все перестановки строки:");
        printPermutations(s);

        String sDigits1 = "123456";
        System.out.println("Состоит ли строка только из цифр: " + consistsOfDigits(sDigits1));

        int n4 = 7, k1 = 2;
        System.out.println("Биномиальный коэффициент: " + binomialCoefficient(n4, k1));

        int a1 = 32, b = 48;
        System.out.println("Наибольший общий делитель: " + gcd(a1, b));
    }

    // Problem 1
    public static int findMinimum(int[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE; // или можно выбросить исключение
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }

    // Problem 2
    public static double findAverage(int[] arr) {
        if (arr.length == 0) return 0; // или можно выбросить исключение
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    // Problem 3
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Problem 4
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Problem 5
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Problem 6
    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // Problem 7
    public static void printPermutations(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        permute(chars, 0, new StringBuilder());
    }

    private static void permute(char[] chars, int start, StringBuilder sb) {
        if (start == chars.length) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, i, start);
            sb.append(chars[start]);
            permute(chars, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            swap(chars, i, start);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Problem 8
    public static boolean consistsOfDigits(String s) {
        return s.matches("\\d+");
    }

    // Problem 9
    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    // Problem 10
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}