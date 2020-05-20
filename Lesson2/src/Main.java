import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        System.out.print("prindime alates nullist paarisarve. Sisesta mitu:");
        Scanner sisse = new Scanner(System.in);
        int x = sisse.nextInt();
        calculateArray(x);
    }

    // TODO prindi välja x paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    private static void calculateArray(int x) {
        int array1dim[] = new int[x];
        array1dim[0] = 2;
        for (int i = 0; i < array1dim.length; i++) {
            System.out.println(array1dim[i]);
            if (i < x - 1) {
                array1dim[i + 1] = array1dim[i] + 2;
            }
        }
        //    int i = 0;
        //    while (i < x) {
        //        System.out.println(array1dim[i]);
        //        if (i<x-1) {
        //        array1dim[i+1]=array1dim[i]+2;
        //       }
        //        i++;
        //   }

    }
}
