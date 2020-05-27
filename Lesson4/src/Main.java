/* TODO all olev on näidis, loo uus klass selle ülesande jaoks
 * Loo uus klass ruut
 * ruudu kontstruktor peab vastu võtma x ja y kordinaadi ning külje pikkuse.
 * objektil peab olema meetod pindala, mis tagastab ruudu pindala
 */
public class Main {
    public static void main(String[] args){
        ruut a = new Ruut(1, 2);
        System.out.println(a.getA());
        System.out.println(a.getB());
        System.out.println(a.getlength());
    }
}