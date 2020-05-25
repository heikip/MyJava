import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    // Prindi välja faili iga teine täht
    public class Main {
        public static void main(String[] args) throws FileNotFoundException {
            File myObj = new File("/home/heiki/ab12.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int i=1;i<data.length();i++) {
                    System.out.print(" " +data.substring(i, i + 1));
                    i++;
                }
            }
            myReader.close();
        }
    }
