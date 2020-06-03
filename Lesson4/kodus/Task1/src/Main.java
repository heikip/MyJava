import java.util.Scanner;

public class Main {

        /* TODO
         * Loe sisse konsoolist 10 arvu massiivi ja trüki välja
         */

        public static void main(String[] args) {
            System.out.print("Sisesta 10 arvu:");
            loejaprindi();

        }
    private static void loejaprindi() {
        int array1dim[] = new int[10];
        for (int i = 0; i < array1dim.length; i++) {
            Scanner sisse = new Scanner(System.in);
            array1dim[i] = sisse.nextInt();
            System.out.println(array1dim[i]);
            }
        }
    }


