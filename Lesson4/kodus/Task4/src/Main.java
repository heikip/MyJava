import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
       System.out.println(isPrime(3));
    }

    /* TODO
     * Leia kas number n on primaar arv või mitte
     * primaar arv on arv, mis jagub ainult 1 ja iseendaga
     * 2, 3, 5, 7, 11, 13, 17, 19, 23
     */
    private static boolean isPrime(int arv) {
        int jagaja = 1;

        while ( arv/jagaja != 1 ) {
            if (arv == jagaja) {
                return true;
            }
            jagatis = jagatav / jagaja;
            jagaja++;
        }
        return false;
    }

}