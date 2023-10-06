import java.util.Arrays;

public class Main {

    public static void main(String[] arg)
    {
        System.out.println((Arrays.deepToString(Task8(new int[][]{{1, 3, 5, 9}, {3,17,27,47}, {2, 4, 6, 5}}))));
    }

    /* 1. Задача: Найти наибольшую подстроку без повторяющихся символов.
        Условие: Напишите метод, который принимает строку и возвращает наибольшую подстроку, в
        которой все символы уникальны.*/
    public static String Task1(String inputString)
    {
        String usedChars = "";

        int start = 0;
        
        int max_start = 0;
        
        int max_lenght = 0;
        
        int lenght = 0;

        for (int i = 0; i < inputString.length(); i++)
        {
            String Char = "" + inputString.charAt(i);
            if (usedChars.contains(Char))
            {
                start = i;
                usedChars = "";
            }
            usedChars = usedChars + Char;
            lenght = i - start + 1;
            if (lenght > max_lenght)
            {
                max_lenght = lenght;
                max_start = start;
            }
        }

        return inputString.substring(max_start, max_start + max_lenght);
    }

    /*2. Задача: Объединить два отсортированных массива.
    Условие: Напишите метод, который принимает два отсортированных массива и возвращает
    новый массив, содержащий все элементы из обоих массивов в отсортированном порядке.*/
    public static int[] Task2(int[] arr1, int[] arr2)
    {
        int[] arr_op = new int[arr1.length + arr2.length];

        int Index = 0;
        for(int element : arr1)
        {
            arr_op[Index] = element;
            Index += 1;
        }
        for(int element : arr2)
        {
            arr_op[Index] = element;
            Index += 1;
        }
        Arrays.sort(arr_op);
        return arr_op;
    }

    /*3. Задача: Найти максимальную сумму подмассива.
    Условие: Напишите метод, который принимает массив целых чисел и возвращает максимальную
    сумму подмассива (последовательных элементов).*/
    public static int Task3(int[] arr) {
        int maxSum = arr[0];
        int sum_g = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum_g = Math.max(arr[i], sum_g + arr[i]);
            maxSum = Math.max(maxSum, sum_g);
        }
        return maxSum;
    }

    /* 4. Задача: Повернуть массив на 90 градусов по часовой стрелке.
    Условие: Напишите метод, который принимает двумерный массив и возвращает новый массив,
    полученный путем поворота исходного массива на 90 градусов по часовой стрелке.*/
    public static int[][] Task4(int[][] matrix_arr)
    {
        int rows = matrix_arr.length;
        int cols = matrix_arr[0].length;
        int[][] newmatrix_arr = new int[cols][rows];
        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                newmatrix_arr[j][rows - 1 - i] = matrix_arr[i][j];
            }
        }
        return newmatrix_arr;
    }

    /* 4. Задача: Найти пару элементов в массиве, сумма которых равна заданному числу.
    Условие: Напишите метод, который принимает массив целых чисел и целое число target и
    возвращает пару элементов массива, сумма которых равна target. Если такая пара не существует,
    метод должен вернуть null.*/
    public static int[] getPair(int[] numbers, int target)
    {
        for(int i = 0; i < numbers.length - 1; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                if(numbers[i] + numbers[j] == target)
                {
                    return new int[]{numbers[i], numbers[j]};
                }
            }
        }
        return null;
    }

    /*6. Задача: Найти сумму всех элементов в двумерном массиве.
    Условие: Напишите метод, который принимает двумерный массив целых чисел и возвращает их
    сумму.*/
    public static int Task6(int[][] matrix_arr)
    {
        int sum = 0;
        for(int[] row : matrix_arr)
        {
            for(int element: row)
            {
                sum += element;
            }
        }
        return sum;
    }

    /*7. Задача: Найти максимальный элемент в каждой строке двумерного массива.
    Условие: Напишите метод, который принимает двумерный массив целых чисел и возвращает
    одномерный массив, содержащий максимальный элемент из каждой строки исходного массива.*/
    public static int[] Task7(int[][] matrix_arr)
    {
        int[] arr_op = new int[matrix_arr.length];
        int index = 0;

        for(int[] row : matrix_arr)
        {
            int maxElement = row[0];

            for(int element : row)
            {
                if(element > maxElement)
                {
                    maxElement = element;
                }
            }
            arr_op[index] = maxElement;
            index++;
        }

        return arr_op;
    }
/*8. Задача: Повернуть двумерный массив на 90 градусов против часовой стрелке.
Условие: Напишите метод, который принимает двумерный массив и возвращает новый массив,
полученный путем поворота исходного массива на 90 градусов против часовой стрелке,*/
    public static int[][] Task8(int[][] matrix_arr)
    {
        int rows = matrix_arr.length;
        int cols = matrix_arr[0].length;

        int[][] newmatrix_arr = new int[cols][rows];

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                newmatrix_arr[cols - 1 - j][i] = matrix_arr[i][j];
            }
        }

        return newmatrix_arr;
    }
}