import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Task1(int n){
        int s = 0;
        int m = n;

        while (n>1){
            //System.out.println(n);
            if (n%2 == 1){
                n = (n*3)+1;
            }
            else {
                n = n/2;
            }
            s += 1;
            if (m >= n){
                m = m;
            }
            else {
                m = n;
            }
        }

        System.out.println("Шагов: "+s);

    }
    public static void Task2(int n){
        int k = n;
        int sum = 0;

        Scanner SCN = new Scanner(System.in);
        for (int i = 0;i< k ; i++){
            int val = SCN.nextInt();
            if (i%2 == 0){
                sum +=val;
            }
            else {
                sum -= val;
            }
        }
        System.out.println("Результат: " + sum);
    }

    public static void Task3(){
        Scanner SCN = new Scanner(System.in);
        int x_final = SCN.nextInt();
        int y_final = SCN.nextInt();


        int x = 0;
        int y = 0;
        int step = 0;

        boolean stoper = false;
        System.out.printf("Введите начальные точки: \n");
        while (stoper == false){
            String line = SCN.nextLine();
            if (line.equals("стоп")){
                stoper = true;
            } else if (line.equals("север")) {
                int val = SCN.nextInt();
                x += val;
                step++;
            }else if (line.equals("юг")) {
                int val = SCN.nextInt();
                x -= val;
                step++;
            }else if (line.equals("восток")) {
                int val = SCN.nextInt();
                y += val;
                step++;
            }else if (line.equals("запад")) {
                int val = SCN.nextInt();
                y -= val;
                step++;
            } else {
                stoper = false;
            }
            if ((x == x_final) &&(y == y_final)){
                stoper = true;
            }
            //System.out.println("x-"+x+" y-"+y);
        }
        System.out.println("Ответ: "+step);
    }
    public static void Task4(){
        Scanner SCN = new Scanner(System.in);

        int which_way = 1;
        int stratig = 1;

        int val = SCN.nextInt();
        for (int i=0;i<val;i++){


            int way_count = SCN.nextInt();
            //System.out.println("---"+way_count);
            int min_hight = 1000000;

            for (int j =0;j<way_count;j++){
                int way_hight = SCN.nextInt();
                if (way_hight < min_hight){
                    min_hight = way_hight;
                }
            }
            if (min_hight > stratig){
                which_way = i+1;
                stratig = min_hight;
            }
        }
        System.out.println(which_way+" "+stratig);
    }
    public static void Task5(){
        Scanner SCN = new Scanner(System.in);
        String line = SCN.nextLine();

        int val1 = 0;
        int val2 = 1;
        for (int i =0;i<line.length();i++){
            char c = line.charAt(i);
            String c1 = String.valueOf(c);
            int gir = Integer.parseInt(c1);
            val2 = val2*gir;
            val1 = val1+gir;
        }
        if ((val1%2==0)&&(val2%2==0)){
            System.out.println("Является дважды чётным");
        }
        else {
            System.out.println("Не является дважды чётным");
        }
    }
    public static void main(String[] args) {
        // Метод введения массива небыл указан, так что массив менять тут >>
        int[][] arr = {{14, 31, 323, 324},
                {44, 35, 46, 234},
                {57, 8, 9323, 32},
                {213,321,4,234}};

        int[] Row = new int[arr.length];
        int[] Tab = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {

                Row[i] += arr[i][j];
                Tab[j] += arr[i][j];

            }
        }
        System.out.println(Arrays.toString(Row));
        System.out.println(Arrays.toString(Tab));

        Scanner SCN = new Scanner(System.in);
        int val;

        System.out.printf("Задача 1 'Сиракузкая последовательность' \nВведите число: ");
        val = SCN.nextInt();
        Task1(val); // Задача 1

        System.out.printf("Задача 2 'Сумма ряда' \nВведите количество, а затем сами числа: ");
        val = SCN.nextInt();
        Task2(val); // Задача 2

        System.out.printf("Задача 3 'Поиск клада'");
        Task3(); // Задача 3

        System.out.printf("Задача 4 'Логистический максимум'");
        Task4(); // Задача 4

        System.out.printf("Задача 5 'Дваждычётное число'");
        Task5(); // Задача 5
    }
}