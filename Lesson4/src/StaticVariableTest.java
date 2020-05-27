public class StaticVariableTest {
    String a;
    static String b;

    public StaticVariableTest(String a1, String b1) {
        a = a1;
        b = b1;
    }

    public void printVariables() {
        System.out.println(a);
        System.out.println(b);
    }
}