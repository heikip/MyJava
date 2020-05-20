public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Wazaaaaa");
        System.out.println("hello"+"\n"+"world");
        printTable(8, 9);
    }

    private static void printTable(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(String.format("%d ", i * j));
            }
            System.out.println();
        }
    }
}