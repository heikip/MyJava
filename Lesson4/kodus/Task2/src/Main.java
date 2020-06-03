import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /* TODO
     * Loe sisse 10 arvu massiivi ja sorteeri need suuruse järgi
     * Näidis sisend : 2, 4, 6, 8, 10, 1, 3, 5, 7, 9
     * Näidis väljund: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     */
    public static void main(String[] args) {
        System.out.print("Sisesta 10 arvu:");
        int array1dim[] = new int[10];
        loesisse(array1dim);
        sort(array1dim);
        print(array1dim);
    }
    private static void loesisse(int [] massiiv ) {

        for (int i = 0; i < massiiv.length; i++) {
            Scanner sisse = new Scanner(System.in);
            massiiv[i] = sisse.nextInt();
            }
    }
    private static void sort(int [] massiiv ) {
        Arrays.sort(massiiv);
    }
    private static void print(int [] massiiv) {
        for (int i = 0; i < massiiv.length; i++) {
            System.out.println(massiiv[i]);
        }
    }
    }
