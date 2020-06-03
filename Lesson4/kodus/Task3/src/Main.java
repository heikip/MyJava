public class Main {
    // TODO
    // Mõtleme matemaatiliselt sellise jada peale, kus jada järgmine element on
    // a) kui arv on paaris arv, siis jagame 2
    // b) kui arv on paaritu siis korrutame 3 ja liidame 1
    // Vaja on luua funktsioon mis arvutaks sellise jada pikkuse
    // Näide: 12, 6, 3, 10, 5, 16, 8, 4, 2, 1. - pikkus: 10
    public static void main(String[] args) {
       // int counter = 1;
        sequence(12);
        //System.out.println(sequenceLength(5));
        //System.out.println(counter);
    }

    // TODO 1
    // Defineeri funktsioon mis tagastab:
    // a) kui i on paaris arv return i/2;
    // b) kui i ei ole paaris arv return i*3+1;
    public static int sequence(int jadaliige){
        System.out.println(jadaliige);
        int counter = 1;
        while (jadaliige != 1 ) {
            if (jadaliige % 2 == 1) {
                jadaliige = jadaliige * 3 + 1;
                System.out.println(jadaliige);
                counter++;
            } else {
                jadaliige = jadaliige / 2;
                System.out.println(jadaliige);
                counter++;
            }
        }
        System.out.println(counter+" jadaliiget");
        return counter;
    }

    // TODO 2
    // Defineeri funktsioon mis arvutab jada pikkuse
    public static int sequenceLength(int i){

        // WRITE CODE HERE
        return 1;
    }
}
